package com.leetcode.service.dp;

/**
 * User: BichongLi
 * Date: 3/24/2017
 * Time: 9:42 AM
 */
public class NumArray {

    private int[] nums;
    private int[] sums;
    private int currentPos;

    public NumArray(int[] nums) {
        this.nums = nums;
        if (nums != null && nums.length > 0) {
            sums = new int[nums.length];
            sums[0] = nums[0];
            currentPos = 0;
        }
    }

    public int sumRange(int i, int j) {
        if (currentPos < j) {
            for (int k = currentPos + 1; k <= j; k++) {
                sums[k] = sums[k - 1] + nums[k];
            }
            currentPos = j;
        }
        if (i == 0) return sums[j];
        return sums[j] - sums[i - 1];
    }
}
