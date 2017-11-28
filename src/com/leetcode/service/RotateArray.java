package com.leetcode.service;

/**
 * User: BichongLi
 * Date: 3/2/2017
 * Time: 1:56 PM
 */
public class RotateArray implements BiSolution<int[], Integer, Void> {

    @Override
    public Void solve(int[] nums, Integer k) {
        if (nums == null || nums.length <= 1 || k <= 0) return null;
        int len = nums.length;
        k %= len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
        return null;
    }

    private void reverse(int[] nums, int start, int end) {
        int tmp;
        while (start < end) {
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
