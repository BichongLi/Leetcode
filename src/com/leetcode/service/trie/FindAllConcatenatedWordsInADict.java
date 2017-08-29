package com.leetcode.service.trie;

import com.leetcode.service.Solution;

import java.util.ArrayList;
import java.util.List;

public class FindAllConcatenatedWordsInADict implements Solution<String[], List<String>> {
    
    @Override
    public List<String> solve(String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        Node root = new Node();
        for (String word : words) {
            insert(word, root);
        }
        for (String word : words) {
            if (dfs(root, root, word, 0, false)) res.add(word);
        }
        return res;
    }

    private boolean dfs(Node root, Node current, String s, int index, boolean splitted) {
        if (index >= s.length()) return false;
        char c = s.charAt(index);
        if (current.next[c - 'a'] != null) {
            current = current.next[c - 'a'];
            if (current.formWord && index == s.length() - 1 && splitted) return true;
            if (current.formWord && dfs(root, root, s, index + 1, true)) return true;
            return dfs(root, current, s, index + 1, splitted);
        }
        return false;
    }

    private void insert(String s, Node root) {
        Node current = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (current.next[c - 'a'] == null) current.next[c - 'a'] = new Node(c);
            current = current.next[c - 'a'];
        }
        current.formWord = true;
    }

    private class Node {
        char c;
        Node[] next = new Node[26];
        boolean formWord = false;

        Node() {
        }

        Node(char c) {
            this.c = c;
        }
    }
}
