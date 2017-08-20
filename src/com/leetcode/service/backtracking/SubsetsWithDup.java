package com.leetcode.service.backtracking;

import com.leetcode.service.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: BichongLi
 * Date: 8/20/2017
 * Time: 10:59 AM
 */
public class SubsetsWithDup implements Solution<int[], List<List<Integer>>> {
    @Override
    public List<List<Integer>> solve(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        int size = 0, startIdx;
        for (int i = 0; i < nums.length; i++) {
            startIdx = i > 0 && nums[i] == nums[i - 1] ? size : 0;
            size = res.size();
            for (int j = startIdx; j < size; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }
}
