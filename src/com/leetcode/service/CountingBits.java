package com.leetcode.service;

/**
 * User: BichongLi
 * Date: 12/19/2016
 * Time: 9:25 PM
 */
public class CountingBits implements Solution<Integer, int[]> {
    @Override
    public int[] solve(Integer num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        for (int i = 0; i <= num; i++) {
            result[i] = result[i / 2] + i % 2;
        }
        return result;
    }
}
