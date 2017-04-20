package com.leetcode.service;

/**
 * User: BichongLi
 * Date: 4/20/2017
 * Time: 9:41 AM
 */
public class OptimalDivision implements Solution<int[], String> {
    @Override
    public String solve(int[] nums) {
        if (nums.length == 1) return String.valueOf(nums[0]);
        if (nums.length == 2) return String.valueOf(nums[0]) + "/" + String.valueOf(nums[1]);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) builder.append(nums[i]);
            else if (i == 1) {
                builder.append("/(");
                builder.append(nums[i]);
            } else {
                builder.append("/");
                builder.append(nums[i]);
            }
        }
        builder.append(")");
        return builder.toString();
    }
}
