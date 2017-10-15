package com.leetcode.service;

public class Rotate implements Solution<int[][], Void> {
    @Override
    public Void solve(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return null;
        int n = matrix.length;
        int round = n / 2;
        for (int i = 0; i < round; i++) {
            for (int j = 0; j < n - 1; j++) {
                int p0x = i, p0y = i + j;
                int p1x = i + j, p1y = i + n -1;
                int p2x = i + n - 1, p2y = i + n - 1 - j;
                int p3x = i + n - 1 - j, p3y = i;
                int tmp = matrix[p3x][p3y];
                matrix[p3x][p3y] = matrix[p2x][p2y];
                matrix[p2x][p2y] = matrix[p1x][p1y];
                matrix[p1x][p1y] = matrix[p0x][p0y];
                matrix[p0x][p0y] = tmp;
            }
            n -= 2;
        }
        return null;
    }
}
