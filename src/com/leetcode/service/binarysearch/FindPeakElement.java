package com.leetcode.service.binarysearch;

import com.leetcode.service.Solution;

public class FindPeakElement implements Solution<int[], Integer> {
    @Override
    public Integer solve(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int lo = 0, hi = nums.length - 1, mid;
        while (lo < hi) {
            mid = (lo + hi) >> 1;
            if (nums[mid] > nums[mid + 1]) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}
