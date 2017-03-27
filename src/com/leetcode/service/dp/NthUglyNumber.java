package com.leetcode.service.dp;

import com.leetcode.service.Solution;

/**
 * User: BichongLi
 * Date: 3/27/2017
 * Time: 2:51 PM
 */
public class NthUglyNumber implements Solution<Integer, Integer> {

    @Override
    public Integer solve(Integer n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int index2 = 1;
        int index3 = 1;
        int index5 = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[index2] * 2, Math.min(dp[index3] * 3, dp[index5] * 5));
            if (dp[i] == dp[index2] * 2) index2++;
            if (dp[i] == dp[index3] * 3) index3++;
            if (dp[i] == dp[index5] * 5) index5++;
        }
        return dp[n];
    }
}
