package com.leetcode.service.trie;

import com.leetcode.service.BiSolution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindWords implements BiSolution<char[][], String[], List<String>> {

    private static int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    @Override
    public List<String> solve(char[][] board, String[] words) {
        if (words == null || words.length == 0 || board == null || board.length == 0) return new ArrayList<>();
        Node root = new Node();
        for (String word : words) insert(word, root);
        Set<String> res = new HashSet<>();
        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                search(root, board, used, new StringBuilder(), i, j, res);
            }
        }
        return new ArrayList<>(res);
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

    private void search(Node current, char[][] board, boolean[][] used,
                        StringBuilder builder, int x, int y, Set<String> res) {
        if (current.next[board[x][y] - 'a'] == null) return;
        int m = board.length, n = board[0].length;
        current = current.next[board[x][y] - 'a'];
        builder.append(board[x][y]);
        used[x][y] = true;
        if (current.formWord) res.add(builder.toString());
        for (int i = 0; i < 4; i++) {
            int tx = x + dirs[i][0];
            int ty = y + dirs[i][1];
            if (tx < 0 || tx >= m || ty < 0 || ty >= n || used[tx][ty]) continue;
            search(current, board, used, builder, tx, ty, res);
        }
        builder.deleteCharAt(builder.length() - 1);
        used[x][y] = false;
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
