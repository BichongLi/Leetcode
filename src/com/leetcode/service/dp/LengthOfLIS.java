package com.leetcode.service.dp;

import com.leetcode.service.Solution;

/**
 * User: BichongLi
 * Date: 3/27/2017
 * Time: 11:12 AM
 */
public class LengthOfLIS implements Solution<int[], Integer> {
    @Override
    public Integer solve(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] l = new int[nums.length];
        l[0] = 1;
        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            l[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    l[i] = Math.max(l[i], l[j] + 1);
                }
            }
            maxLength = maxLength > l[i] ? maxLength : l[i];
        }
        return maxLength;
    }
}
