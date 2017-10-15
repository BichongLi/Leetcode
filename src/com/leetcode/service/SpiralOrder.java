package com.leetcode.service;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder implements Solution<int[][], List<Integer>> {

    private static int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    @Override
    public List<Integer> solve(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        int round = m < n ? (m + 1) / 2 : (n + 1) / 2;
        for (int i = 0; i < round; i++) {
            int x = i, y = i - 1;
            for (int j = 0; j < n; j++) {
                x += dirs[0][0];
                y += dirs[0][1];
                res.add(matrix[x][y]);
            }
            for (int j = 0; j < m - 1; j++) {
                x += dirs[1][0];
                y += dirs[1][1];
                res.add(matrix[x][y]);
            }
            if (m > 1 && n > 1) {
                for (int j = 0; j < n - 1; j++) {
                    x += dirs[2][0];
                    y += dirs[2][1];
                    res.add(matrix[x][y]);
                }
                for (int j = 0; j < m - 2; j++) {
                    x += dirs[3][0];
                    y += dirs[3][1];
                    res.add(matrix[x][y]);
                }
            }
            m -= 2;
            n -= 2;
        }
        return res;
    }
}
