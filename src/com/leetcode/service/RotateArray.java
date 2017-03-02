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
        k = k % len;
        int[] tmp = new int[k];
        for (int i  = 1; i <= k; i++) {
            tmp[k - i] = nums[len - i];
        }
        for (int i = 1; i <= len - k; i++) {
            nums[len - i] = nums[len - k - i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = tmp[i];
        }
        return null;
    }
}
