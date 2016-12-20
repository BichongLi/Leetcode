package com.leetcode.service;

/**
 * User: BichongLi
 * Date: 12/19/2016
 * Time: 8:46 PM
 */
public class ArithmeticSlices implements Solution<int[], Integer> {

    @Override
    public Integer solve(int[] A) {
        int result = 0;
        int current = 0;
        if (A.length < 3) return result;
        for (int i = 2; i < A.length; i++) {
            if (isArithmeticSlices(A[i - 2], A[i - 1], A[i])) {
                current ++;
                result += current;
            } else {
                current = 0;
            }
        }
        return result;
    }

    private boolean isArithmeticSlices(int a1, int a2, int a3) {
        return (a2 - a1) == (a3 - a2);
    }
}
