package com.leetcode.service.trie;

import com.leetcode.service.BiSolution;

import java.util.List;

public class ReplaceWords implements BiSolution<List<String>, String, String> {

    private void insert(String s, Node root) {
        Node current = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (current.next[c - 'a'] == null) current.next[c - 'a'] = new Node(c);
            current = current.next[c - 'a'];
        }
        current.formWord = true;
    }

    private String search(String word, Node root) {
        Node current = root;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.next[c - 'a'] != null) {
                builder.append(c);
                current = current.next[c - 'a'];
                if (current.formWord) return builder.toString();
            } else break;
        }
        return word;
    }

    @Override
    public String solve(List<String> dict, String sentence) {
        if (dict == null || dict.isEmpty() || sentence == null || sentence.length() == 0) return sentence;
        Node root = new Node();
        dict.forEach(word -> insert(word, root));
        String[] words = sentence.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            String replacement = search(word, root);
            if (builder.length() == 0) builder.append(replacement);
            else builder.append(" ").append(replacement);
        }
        return builder.toString();
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
