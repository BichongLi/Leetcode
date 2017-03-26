package com.leetcode.service.dp;

import com.leetcode.service.BiSolution;

/**
 * User: BichongLi
 * Date: 3/26/2017
 * Time: 9:01 AM
 */
public class CombinationSum4 implements BiSolution<int[], Integer, Integer> {
    @Override
    public Integer solve(int[] nums, Integer target) {
        if (target == 0) return 1;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            int res = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    res += dp[i - nums[j]];
                }
            }
            dp[i] = res;
        }
        return dp[target];
    }
}
