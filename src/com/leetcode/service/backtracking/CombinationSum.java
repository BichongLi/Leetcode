package com.leetcode.service.backtracking;

import com.leetcode.service.BiSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: BichongLi
 * Date: 8/19/2017
 * Time: 9:41 AM
 */
public class CombinationSum implements BiSolution<int[], Integer, List<List<Integer>>> {
    @Override
    public List<List<Integer>> solve(int[] candidates, Integer target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtracking(int[] candidates, int target, int start, int preSum,
                              List<Integer> preState, List<List<Integer>> res) {
        for (int i = start; i < candidates.length; i++) {
            preState.add(candidates[i]);
            if (preSum + candidates[i] == target) {
                res.add(new ArrayList<>(preState));
                preState.remove(preState.size() - 1);
                break;
            } else if (preSum + candidates[i] > target) {
                preState.remove(preState.size() - 1);
                break;
            } else {
                backtracking(candidates, target, i, preSum + candidates[i], preState, res);
                preState.remove(preState.size() - 1);
            }
        }
    }
}
