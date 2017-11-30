package com.leetcode.service.backtracking;

import com.leetcode.service.BiSolution;

public class Exist implements BiSolution<char[][], String, Boolean> {

    private boolean[][] used;
    private int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    @Override
    public Boolean solve(char[][] board, String word) {
        if (board == null || board.length == 0 ||
                word == null || word.length() == 0) return false;
        int m = board.length, n = board[0].length;
        used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int x, int y, String word, int index) {
        if (board[x][y] != word.charAt(index)) return false;
        if (index == word.length() - 1) return true;
        used[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int tx = x + dirs[i][0];
            int ty = y + dirs[i][1];
            if (tx >= 0 && tx < board.length &&
                    ty >= 0 && ty < board[0].length && !used[tx][ty]) {
                if (dfs(board, tx, ty, word, index + 1)) return true;
            }
        }
        used[x][y] = false;
        return false;
    }
}
