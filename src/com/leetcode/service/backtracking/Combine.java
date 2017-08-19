package com.leetcode.service.backtracking;

import com.leetcode.service.BiSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * User: BichongLi
 * Date: 8/19/2017
 * Time: 9:31 AM
 */
public class Combine implements BiSolution<Integer, Integer, List<List<Integer>>> {
    @Override
    public List<List<Integer>> solve(Integer n, Integer k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k > n) return res;
        backtracking(n, k, new ArrayList<>(), 1, res);
        return res;
    }

    private void backtracking(int n, int k, List<Integer> preState,
                              int start, List<List<Integer>> res) {
        for (int i = start; i <= n; i++) {
            preState.add(i);
            if (preState.size() == k) res.add(new ArrayList<>(preState));
            else backtracking(n, k, preState, i + 1, res);
            preState.remove(preState.size() - 1);
        }
    }
}
