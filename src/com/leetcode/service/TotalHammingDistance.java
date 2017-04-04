package com.leetcode.service;

/**
 * User: BichongLi
 * Date: 4/4/2017
 * Time: 9:30 PM
 */
public class TotalHammingDistance implements Solution<int[], Integer> {
    @Override
    public Integer solve(int[] nums) {
        int set, notSet;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            set = 0;
            notSet = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & 1) == 1) set++;
                else notSet++;
                nums[j] = nums[j] >>> 1;
            }
            result += set * notSet;
        }
        return result;
    }
}
