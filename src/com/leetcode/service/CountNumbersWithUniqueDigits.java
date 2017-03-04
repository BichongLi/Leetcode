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
        if (count[n] != 0) return count[n];
        calculate(n);
        return count[n];
    }

    private void calculate(int n) {
        if (count[n - 1] == 0) {
            calculate(n - 1);
        }
        int tmp = 1;
        for (int i = 11 - n; i <= 9; i++) {
            tmp *= i;
        }
        count[n] = count[n - 1] + tmp * 9;
    }
}
