package com.leetcode.service.dp;

import com.leetcode.service.Solution;

/**
 * User: BichongLi
 * Date: 3/25/2017
 * Time: 2:28 PM
 */
public class NumTrees implements Solution<Integer, Integer> {
    @Override
    public Integer solve(Integer n) {
        if (n < 1) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
