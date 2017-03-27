package com.leetcode.service.dp;

import com.leetcode.service.Solution;

/**
 * User: BichongLi
 * Date: 3/27/2017
 * Time: 4:48 PM
 */
public class Rob implements Solution<int[], Integer> {
    @Override
    public Integer solve(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return Math.max(rangeRob(1, nums.length - 1, nums),
                nums[0] + rangeRob(2, nums.length - 2, nums));
    }

    private int rangeRob(int lo, int hi, int[] nums) {
        int prev = 0;
        int current = 0;
        int tmp;
        for (int i = lo; i <= hi; i++) {
            tmp = current;
            current = Math.max(current, prev + nums[i]);
            prev = tmp;
        }
        return current;
    }
}
