package com.leetcode.service;

/**
 * User: BichongLi
 * Date: 3/4/2017
 * Time: 2:48 PM
 */
public class CanPartition implements Solution<int[], Boolean> {
    @Override
    public Boolean solve(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return (sum & 1) == 0 && subsetSum(nums, (sum >>> 1)) > 0;
    }

    private double subsetSum(int[] nums, int target) {
        double[] dp = new double[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int s = target; s >= nums[i]; s--) {
                dp[s] += dp[s - nums[i]];
            }
        }
        return dp[target];
    }
}
