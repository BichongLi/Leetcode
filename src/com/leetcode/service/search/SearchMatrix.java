package com.leetcode.service.search;

import com.leetcode.service.BiSolution;

/**
 * @author bichongli on 10/17/2017
 */
public class SearchMatrix implements BiSolution<int[][], Integer, Boolean> {
    @Override
    public Boolean solve(int[][] matrix, Integer target) {
        if (matrix == null || matrix.length == 0) return false;
        return search(matrix, 0, 0, matrix.length, matrix[0].length, target);
    }

    private boolean search(int[][] matrix, int x, int y, int m, int n, int target) {
        if (m <= 0 || n <= 0) return false;
        int midX = x + (m - 1) / 2;
        int midY = y + (n - 1) / 2;
        if (matrix[midX][midY] == target) return true;
        else if (matrix[midX][midY] < target) {
            return search(matrix, x, midY + 1, m, n - (midY - y + 1), target) ||
                    search(matrix, midX + 1, y, m - (midX - x + 1), midY - y + 1, target);
        } else {
            return search(matrix, x, y, m, midY - y, target) ||
                    search(matrix, x, midY, midX - x, n - (midY - y), target);
        }
    }
}
