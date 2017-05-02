package com.leetcode.service;

/**
 * User: BichongLi
 * Date: 4/27/2017
 * Time: 9:29 AM
 */
public class FindDuplicate implements Solution<int[], Integer> {
    @Override
    public Integer solve(int[] nums) {
        int low = 1;
        int high = nums.length;
        int mid, count;
        while (low < high) {
            mid = (high - low) / 2 + low;
            count = countLessThanEqual(nums, mid);
            if (count > mid) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    private int countLessThanEqual(int[] nums, int target) {
        int count = 0;
        for (int n : nums) {
            if (n <= target) count++;
        }
        return count;
    }
}
