package com.leetcode.service.dp;

import com.leetcode.service.Solution;

public class CanJump implements Solution<int[], Boolean> {
    @Override
    public Boolean solve(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int lens = nums.length;
        boolean[] dp = new boolean[lens];
        dp[0] = true;
        for (int i = 1; i < lens; i++) {
            for (int j = 1; j <= i; j++) {
                if (dp[i - j] && nums[i - j] >= j) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[lens - 1];
    }
}
