package com.leetcode.service.backtracking;

import com.leetcode.service.BiSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: BichongLi
 * Date: 8/20/2017
 * Time: 3:24 PM
 */
public class CombinationSum2 implements BiSolution<int[], Integer, List<List<Integer>>> {
    @Override
    public List<List<Integer>> solve(int[] candidates, Integer target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        backtracking(candidates, 0, target, new ArrayList<>(), 0, res);
        return res;
    }

    private void backtracking(int[] candidates, int start, int target,
                              List<Integer> preState, int preSum, List<List<Integer>> res) {
        for (int i = start; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && i > start) {
                continue;
            } else {
                preState.add(candidates[i]);
                if (preSum + candidates[i] == target) {
                    res.add(new ArrayList<>(preState));
                    preState.remove(preState.size() - 1);
                    break;
                } else if (preSum + candidates[i] < target) {
                    backtracking(candidates, i + 1, target, preState, preSum + candidates[i], res);
                    preState.remove(preState.size() - 1);
                } else {
                    preState.remove(preState.size() - 1);
                    break;
                }
            }
        }
    }
}
