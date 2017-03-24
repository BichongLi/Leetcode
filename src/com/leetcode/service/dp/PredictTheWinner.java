package com.leetcode.service.dp;

import com.leetcode.service.Solution;

/**
 * User: BichongLi
 * Date: 3/24/2017
 * Time: 1:33 PM
 */
public class PredictTheWinner implements Solution<int[], Boolean> {
    @Override
    public Boolean solve(int[] nums) {
        if (nums.length < 3) return true;
        int[] sums = new int[nums.length];
        int[][] dp = new int[nums.length][nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            dp[i][i] = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (i > 0) {
                    dp[i][j] = Math.max(sums[j] - sums[i - 1] - dp[i + 1][j],
                            sums[j] - sums[i - 1] - dp[i][j - 1]);
                } else {
                    dp[i][j] = Math.max(sums[j] - dp[i + 1][j],
                            sums[j] - dp[i][j - 1]);
                }
            }
        }
        return dp[0][nums.length - 1] >= sums[nums.length - 1] - dp[0][nums.length - 1];
    }
}
