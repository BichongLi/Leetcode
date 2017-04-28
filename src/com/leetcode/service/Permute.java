package com.leetcode.service;

import java.util.*;

/**
 * User: BichongLi
 * Date: 4/28/2017
 * Time: 11:09 AM
 */
public class Permute implements Solution<int[], List<List<Integer>>> {

    private List<List<Integer>> result = new ArrayList<>();

    @Override
    public List<List<Integer>> solve(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        dfs(nums, flag, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, boolean[] flag, List<Integer> seq) {
        if (seq.size() == nums.length) {
            result.add(new ArrayList<>(seq));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                seq.add(nums[i]);
                dfs(nums, flag, seq);
                seq.remove(seq.size() - 1);
                flag[i] = false;
            }
        }
    }
}
