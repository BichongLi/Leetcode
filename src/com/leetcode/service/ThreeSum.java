package com.leetcode.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum implements Solution<int[], List<List<Integer>>> {
    @Override
    public List<List<Integer>> solve(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = 0 - nums[i];
            res.addAll(twoSum(nums, i + 1, nums.length - 1, target, nums[i]));
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int lo, int hi, int target, int base) {
        List<List<Integer>> res = new ArrayList<>();
        int sum;
        while (lo < hi) {
            sum = nums[lo] + nums[hi];
            if (sum == target) {
                res.add(Arrays.asList(base, nums[lo], nums[hi]));
                while (lo < hi && nums[lo + 1] == nums[lo]) lo++;
                while (lo < hi && nums[hi - 1] == nums[hi]) hi--;
                lo++;
                hi--;
            } else if (sum < target) {
                lo++;
            } else {
                hi--;
            }
        }
        return res;
    }
}
