package com.leetcode.service;

public class GenerateMatrix implements Solution<Integer, int[][]> {

    private static int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    @Override
    public int[][] solve(Integer n) {
        if (n <= 0) return new int[0][];
        int x = 0, y = 0, d = 0, tx, ty;
        int[][] matrix = new int[n][n];
        for (int i = 1; i <= n * n; i++) {
            matrix[x][y] = i;
            tx = dirs[d][0] + x;
            ty = dirs[d][1] + y;
            if (tx < 0 || tx >= n || ty < 0 || ty >= n || matrix[tx][ty] != 0) {
                d = (d + 1) % 4;
                tx = dirs[d][0] + x;
                ty = dirs[d][1] + y;
            }
            x = tx;
            y = ty;
        }
        return matrix;
    }
}
