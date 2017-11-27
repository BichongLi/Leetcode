package com.leetcode.service.binarysearch;

import com.leetcode.service.BiSolution;

public class Search33 implements BiSolution<int[], Integer, Integer> {
    @Override
    public Integer solve(int[] nums, Integer target) {
        if (nums == null || nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1, mid;
        while (lo < hi) {
            mid = (lo + hi) >> 1;
            if (nums[mid] > nums[hi]) lo = mid + 1;
            else hi = mid;
        }
        int rotate = lo;
        lo = 0;
        hi = nums.length - 1;
        while (lo <= hi) {
            mid = (lo + hi) >> 1;
            int realMid = (mid + rotate) % nums.length;
            if (nums[realMid] == target) return realMid;
            if (nums[realMid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
}
