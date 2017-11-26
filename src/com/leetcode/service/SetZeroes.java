package com.leetcode.service;

public class SetZeroes implements Solution<int[][], Void> {
    @Override
    public Void solve(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return null;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int col0 = 1;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j > 0) matrix[0][j] = 0;
                }
            }
        }
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
            if (col0 == 0) matrix[i][0] = 0;
        }
        return null;
    }
}
