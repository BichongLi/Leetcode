package com.leetcode.service;

import java.util.ArrayList;
import java.util.List;

/**
 * User: BichongLi
 * Date: 3/18/2017
 * Time: 10:08 AM
 */
public class CombinationSum3 implements BiSolution<Integer, Integer, List<List<Integer>>> {

    private List<List<Integer>> pathList;

    @Override
    public List<List<Integer>> solve(Integer k, Integer n) {
        pathList = new ArrayList<>();
        search(k, n, 0, new ArrayList<>());
        return pathList;
    }

    private void search(int k, int sum, int last, List<Integer> path) {
        if (k == 1) {
            if (sum > 9 || sum <= last) return;
            path.add(sum);
            pathList.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        int max = sum > 9 ? 9 : sum - 1;
        for (int i = last + 1; i <= max; i++) {
            path.add(i);
            search(k - 1, sum - i, i, path);
            path.remove(path.size() - 1);
        }
    }
}
