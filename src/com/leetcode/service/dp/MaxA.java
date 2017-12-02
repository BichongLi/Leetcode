package com.leetcode.service.dp;

import com.leetcode.service.Solution;

public class MaxA implements Solution<Integer, Integer> {
    @Override
    public Integer solve(Integer N) {
        int[] dp = new int[N + 1];
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = i;
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] * (j - 1));
            }
        }
        return dp[N];
    }
}
