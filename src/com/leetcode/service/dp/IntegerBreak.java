package com.leetcode.service.dp;

import com.leetcode.service.Solution;

/**
 * User: BichongLi
 * Date: 3/26/2017
 * Time: 9:51 AM
 */
public class IntegerBreak implements Solution<Integer, Integer> {
    @Override
    public Integer solve(Integer n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n < 4) return n;
        int[] nums = new int[4];
        while (n >= 4) {
            nums[2]++;
            n -= 2;
        }
        nums[n]++;
        if (nums[2] > 2) {
            nums[3] += nums[2] / 3 * 2;
            nums[2] -= nums[2] / 3 * 3;
        }
        int product = 1;
        for (int i = 0; i < nums[2]; i++) {
            product *= 2;
        }
        for (int i = 0; i < nums[3]; i++) {
            product *= 3;
        }
        return product;
    }
}
