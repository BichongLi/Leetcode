package com.leetcode.service;

/**
 * User: BichongLi
 * Date: 3/31/2017
 * Time: 3:49 PM
 */
public class SingleNumber implements Solution<int[], int[]> {
    @Override
    public int[] solve(int[] nums) {
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s ^= nums[i];
        }
        int mask = ((s ^ (s -1)) + 1) >>> 1;
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & mask) == 0) {
                res[0] ^= nums[i];
            } else {
                res[1] ^= nums[i];
            }
        }
        return res;
    }
}
