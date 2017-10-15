package com.leetcode.service.math;

import com.leetcode.service.Solution;

public class FindMin implements Solution<int[], Integer> {
    @Override
    public Integer solve(int[] nums) {
        int mid, lo = 0, hi = nums.length - 1;
        if (lo + 1 == hi) return Math.min(nums[lo], nums[hi]);
        while (lo < hi) {
            if (nums[lo] < nums[hi]) return nums[lo];
            mid = (lo + hi) / 2;
            if (nums[mid] >= nums[lo]) lo = mid + 1;
            else hi = mid;
        }
        return nums[lo];
    }
}
