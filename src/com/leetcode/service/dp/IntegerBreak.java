package com.leetcode.service.dp;

import com.leetcode.service.Solution;

/**
 * User: BichongLi
 * Date: 3/26/2017
 * Time: 9:51 AM
 */
public class IntegerBreak implements Solution<Integer, Integer> {
    @Override
    public Integer solve(Integer n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = i - 1; j >= 1; j--) {
                dp[i] = Math.max(dp[i], Math.max(dp[i - j], i - j) * Math.max(j, dp[j]));
            }
        }
        return dp[n];
    }
}
