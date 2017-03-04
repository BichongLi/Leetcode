package com.leetcode.service;

/**
 * User: BichongLi
 * Date: 3/4/2017
 * Time: 1:44 PM
 */
public class FindTargetSumWays implements BiSolution<int[], Integer, Integer> {

    @Override
    public Integer solve(int[] nums, Integer S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (S > sum || S < -sum || ((S + sum) & 1) != 0) return 0;
        sum = (S + sum) >>> 1;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int s = sum; s >= nums[i]; s--) {
                dp[s] += dp[s - nums[i]];
            }
        }
        return dp[sum];
    }
}
