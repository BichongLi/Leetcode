package com.leetcode.service.dp;

import com.leetcode.service.Solution;

/**
 * User: BichongLi
 * Date: 7/28/2017
 * Time: 9:34 AM
 */
public class GetMoneyAmount implements Solution<Integer, Integer> {

    @Override
    public Integer solve(Integer n) {
        int dp[][] = new int[n + 1][n + 1];
        return dfs(dp, 1, n);
    }

    public int dfs(int dp[][], int start, int end) {
        if (start >= end) return 0;
        if (dp[start][end] != 0) return dp[start][end];
        dp[start][end] = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            int tmp = Math.max(dfs(dp, start, i - 1), dfs(dp, i + 1, end)) + i;
            dp[start][end] = Math.min(tmp, dp[start][end]);
        }
        return dp[start][end];
    }
}
