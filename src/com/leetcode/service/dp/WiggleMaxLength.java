package com.leetcode.service.dp;

import com.leetcode.service.Solution;

/**
 * User: BichongLi
 * Date: 3/25/2017
 * Time: 8:36 PM
 */
public class WiggleMaxLength implements Solution<int[], Integer> {
    @Override
    public Integer solve(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                } else if (nums[i] < nums[j]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                }
                max = max > dp[i][0] ? max : dp[i][0];
                max = max > dp[i][1] ? max : dp[i][1];
            }
        }
        return max;
    }
}
