package com.leetcode.service.dp;

import com.leetcode.service.BiSolution;

/**
 * User: BichongLi
 * Date: 3/25/2017
 * Time: 8:11 PM
 */
public class UniquePaths implements BiSolution<Integer, Integer, Integer> {
    @Override
    public Integer solve(Integer m, Integer n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
