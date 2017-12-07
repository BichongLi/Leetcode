package com.leetcode.service;

/**
 * User: BichongLi
 * Date: 3/4/2017
 * Time: 9:46 AM
 */
public class CountNumbersWithUniqueDigits implements Solution<Integer, Integer> {

    private int[] count = {1, 10, 91, 0, 0, 0, 0, 0, 0, 0, 0};

    @Override
    public Integer solve(Integer n) {
        if (n > 10) n = 10;
        int[] count = new int[11];
        count[0] = 1;
        count[1] = 10;
        count[2] = 91;
        for (int i = 3; i <= n; i++) {
            count[i] = (count[i - 1] - count[i - 2]) * (11 - i) + count[i - 1];
        }
        return count[n];
    }
}
