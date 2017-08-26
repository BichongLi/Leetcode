package com.leetcode.service.bfs;

import com.leetcode.service.Solution;

import java.util.ArrayDeque;
import java.util.Queue;

public class SurroundedRegions implements Solution<char[][], Void> {

    private static int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    @Override
    public Void solve(char[][] board) {
        if (board == null || board.length == 0) return null;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') bfs(board, 0, i);
            if (board[m - 1][i] == 'O') bfs(board, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') bfs(board, i, 0);
            if (board[i][n - 1] == 'O') bfs(board, i, n - 1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'A') board[i][j] = 'O';
            }
        }
        return null;
    }

    private void bfs(char[][] board, int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[] start = new int[]{x, y};
        int m = board.length;
        int n = board[0].length;
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            board[current[0]][current[1]] = 'A';
            for (int i = 0; i < 4; i++) {
                int[] next = new int[]{current[0] + dirs[i][0], current[1] + dirs[i][1]};
                if (!isOutOfBound(next, m, n) && board[next[0]][next[1]] == 'O') {
                    queue.add(next);
                }
            }
        }
    }

    private boolean isOutOfBound(int[] c, int m, int n) {
        return c[0] < 0 || c[0] >= m || c[1] < 0 || c[1] >= n;
    }
}
