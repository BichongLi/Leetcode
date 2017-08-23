package com.leetcode.service.backtracking;

import com.leetcode.service.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bichongli on 8/22/2017
 */
public class PermuteUnique implements Solution<int[], List<List<Integer>>> {
    @Override
    public List<List<Integer>> solve(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used, res, new ArrayList<>());
        return res;
    }

    private void backtracking(int[] nums, boolean[] used,
                              List<List<Integer>> res, List<Integer> preState) {
        if (preState.size() == nums.length) {
            res.add(new ArrayList<>(preState));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            preState.add(nums[i]);
            used[i] = true;
            backtracking(nums, used, res, preState);
            preState.remove(preState.size() - 1);
            used[i] = false;
        }
    }
}
