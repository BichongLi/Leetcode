package com.leetcode.service.math;

import com.leetcode.service.Solution;

public class SingleNonDuplicate implements Solution<int[], Integer> {
    @Override
    public Integer solve(int[] nums) {
        int res = 0;
        for (int num : nums) res ^= num;
        return res;
    }
}
