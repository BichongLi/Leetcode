package com.leetcode.service;

/**
 * User: BichongLi
 * Date: 3/31/2017
 * Time: 4:00 PM
 */
public class FindDiagonalOrder implements Solution<int[][], int[]> {

    @Override
    public int[] solve(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int currentDir = 1;
        int currentX = 0;
        int currentY = 0;
        for (int i = 0; i < m * n; i++) {
            res[i] = matrix[currentX][currentY];
            currentX -= currentDir;
            currentY += currentDir;
            if (currentX < 0) {
                currentX = 0;
                currentDir = -currentDir;
            }
            if (currentY < 0) {
                currentY = 0;
                currentDir = -currentDir;
            }
            if (currentX >= m) {
                currentX = m -1;
                currentY += 2;
                currentDir = -currentDir;
            }
            if (currentY >= n) {
                currentY = n -1;
                currentX += 2;
                currentDir = -currentDir;
            }
        }
        return res;
    }
}
