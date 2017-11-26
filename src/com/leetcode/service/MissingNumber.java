package com.leetcode.service;

public class MissingNumber implements Solution<int[], Integer> {
    @Override
    public Integer solve(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        return n * (n + 1) / 2 - sum;
    }
}
