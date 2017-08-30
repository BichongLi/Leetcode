package com.leetcode.service.trie;

import com.leetcode.service.Solution;

import java.util.ArrayList;
import java.util.List;

public class PalindromePairs implements Solution<String[], List<List<Integer>>> {
    @Override
    public List<List<Integer>> solve(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        Node root = new Node();
        for (int i = 0; i < words.length; i++) {
            insert(words[i], root, i);
        }
        for (int i = 0; i < words.length; i++) {
            List<Integer> indexes = search(root, words[i]);
            for (Integer index : indexes) {
                if (index == i) continue;
                List<Integer> tmp = new ArrayList<>();
                tmp.add(index);
                tmp.add(i);
                res.add(tmp);
            }
        }
        return res;
    }

    private void insert(String s, Node root, int index) {
        Node current = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (current.next[c - 'a'] == null) current.next[c - 'a'] = new Node(c);
            current = current.next[c - 'a'];
        }
        current.setIndex(index);
    }

    private List<Integer> search(Node root, String word) {
        Node current = root;
        List<Integer> res = new ArrayList<>();
        if (root.index != -1 && isPalindrome(word, 0, word.length() - 1)) res.add(root.index);
        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            if (current.next[c - 'a'] == null) return res;
            else {
                current = current.next[c - 'a'];
                if (current.index != -1 && isPalindrome(word, 0, i - 1)) {
                    res.add(current.index);
                }
            }
        }
        dfs(res, current, new StringBuilder());
        return res;
    }

    private void dfs(List<Integer> indexes, Node current, StringBuilder builder) {
        if (current.index != -1 && builder.length() != 0 &&
                isPalindrome(builder.toString(), 0, builder.length() - 1)) {
            indexes.add(current.index);
        }
        for (int i = 0; i < 26; i++) {
            if (current.next[i] == null) continue;
            builder.append((char) (i + 'a'));
            dfs(indexes, current.next[i], builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    private class Node {
        char c;
        Node[] next = new Node[26];
        int index = -1;

        Node() {
        }

        Node(char c) {
            this.c = c;
        }

        void setIndex(int index) {
            this.index = index;
        }
    }
}
