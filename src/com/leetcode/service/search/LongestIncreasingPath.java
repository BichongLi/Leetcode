package com.leetcode.service.search;

import com.leetcode.service.Solution;

/**
 * @author bichongli on 9/11/2017
 */
public class LongestIncreasingPath implements Solution<int[][], Integer> {

    private static final int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    @Override
    public Integer solve(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int max = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                max = Math.max(max, dfs(matrix, memo, i, j));
        return max;
    }

    private int dfs(int[][] matrix, int[][] memo, int x, int y) {
        if (memo[x][y] > 0) return memo[x][y];
        int m = matrix.length, n = matrix[0].length;
        memo[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int tx = x + dirs[i][0];
            int ty = y + dirs[i][1];
            if (tx < 0 || tx >= m || ty < 0 || ty >= n || matrix[tx][ty] <= matrix[x][y]) continue;
            int length = 1 + dfs(matrix, memo, tx, ty);
            memo[x][y] = Math.max(memo[x][y], length);
        }
        return memo[x][y];
    }
}
