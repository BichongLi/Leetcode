package com.leetcode.service.dp;

import com.leetcode.service.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * User: BichongLi
 * Date: 3/27/2017
 * Time: 1:25 PM
 */
public class NumSquares implements Solution<Integer, Integer> {
    @Override
    public Integer solve(Integer n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            int j = 1;
            while (j * j <= i) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                j++;
            }
        }
        return dp[n];
    }
}
