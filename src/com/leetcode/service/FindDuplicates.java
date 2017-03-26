package com.leetcode.service;

import java.util.ArrayList;
import java.util.List;

/**
 * User: BichongLi
 * Date: 3/23/2017
 * Time: 11:15 PM
 */
public class FindDuplicates implements Solution<int[], List<Integer>> {
    @Override
    public List<Integer> solve(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int pos = Math.abs(nums[i]) - 1;
            if (nums[pos] < 0) result.add(Math.abs(nums[i]));
            nums[pos] = -nums[pos];
        }
        return result;
    }
}
