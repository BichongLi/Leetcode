package com.leetcode.service.dp;

import com.leetcode.service.Solution;

/**
 * @author bichongli on 10/10/2017
 */
public class MinSteps implements Solution<Integer, Integer> {
    @Override
    public Integer solve(Integer n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = i / 2; j > 0; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + i / j;
                    break;
                }
            }
        }
        return dp[n];
    }
}
