package com.leetcode.service.dp;

import com.leetcode.service.Solution;

/**
 * User: BichongLi
 * Date: 3/24/2017
 * Time: 8:47 PM
 */
public class MinPathSum implements Solution<int[][], Integer> {
    @Override
    public Integer solve(int[][] grid) {
        if (grid == null) return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0) {
                    if (j == 0) dp[i][j] = grid[i][j];
                    else dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1] + grid[i][j], dp[i - 1][j] + grid[i][j]);
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
