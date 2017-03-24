package com.leetcode.service.dp;

import com.leetcode.service.BiSolution;

/**
 * User: BichongLi
 * Date: 3/24/2017
 * Time: 9:57 AM
 */
public class CheckSubarraySum implements BiSolution<int[], Integer, Boolean> {

    @Override
    public Boolean solve(int[] nums, Integer k) {
        if (nums == null || nums.length < 2) return false;
        int[] s = new int[nums.length];
        s[0] = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) s[i] = nums[i];
            else {
                s[i] = s[i - 1] + nums[i];
                if (k == 0) {
                    if (s[i] == 0) return true;
                } else if (s[i] % k == 0) return true;
            }
        }
        for (int i = 1; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (k == 0) {
                    if (s[j] - s[i - 1] == 0) return true;
                } else if ((s[j] - s[i - 1]) % k == 0) return true;
            }
        }
        return false;
    }
}
