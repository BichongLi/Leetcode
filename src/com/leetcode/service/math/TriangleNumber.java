package com.leetcode.service.math;

import com.leetcode.service.Solution;

import java.util.Arrays;

public class TriangleNumber implements Solution<int[], Integer> {
    @Override
    public Integer solve(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == 0) continue;
                int sum = nums[i] + nums[j];
                int index = findIndexOfLargestSmallerThan(sum, nums);
                if (index != -1) count += (index - j);
            }
        }
        return count;
    }

    private int findIndexOfLargestSmallerThan(int target, int[] nums) {
        int lo = 0, hi = nums.length - 1;
        if (target < nums[lo]) return -1;
        if (target > nums[hi]) return hi;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] >= target) hi = mid;
            else if (nums[mid + 1] >= target) return mid;
            else lo = mid;
        }
        return -1;
    }
}
