package com.leetcode.service.backtracking;

import com.leetcode.service.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: BichongLi
 * Date: 8/24/2017
 * Time: 8:22 AM
 */
public class FindSubsequences implements Solution<int[], List<List<Integer>>> {
    @Override
    public List<List<Integer>> solve(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 2) return res;
        backtracking(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtracking(int[] nums, int start, List<Integer> preState,
                              List<List<Integer>> res) {
        if (preState.size() > 1) res.add(new ArrayList<>(preState));
        Set<Integer> used = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (!used.contains(nums[i]) &&
                    (preState.isEmpty() || nums[i] >= preState.get(preState.size() - 1))) {
                preState.add(nums[i]);
                used.add(nums[i]);
                backtracking(nums, i + 1, preState, res);
                preState.remove(preState.size() - 1);
            }
        }
    }
}
