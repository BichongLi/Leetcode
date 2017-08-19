package com.leetcode.service.backtracking;

import com.leetcode.service.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: BichongLi
 * Date: 8/19/2017
 * Time: 9:08 AM
 */
public class Subsets implements Solution<int[], List<List<Integer>>> {
    @Override
    public List<List<Integer>> solve(int[] nums) {
        if (nums == null) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        backtracking(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private void backtracking(int[] nums, int start, List<Integer> preState,
                              List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(preState));
        for (int i = start; i < nums.length; i++) {
            preState.add(nums[i]);
            backtracking(nums, i + 1, preState, subsets);
            preState.remove(Integer.valueOf(nums[i]));
        }
    }
}
