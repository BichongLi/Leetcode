package com.leetcode.service;

/**
 * User: BichongLi
 * Date: 4/23/2017
 * Time: 1:40 PM
 */
public class MagicalString implements Solution<Integer, Integer> {

    private int[] S = new int[100005];

    @Override
    public Integer solve(Integer n) {
        if (n < 1) return 0;
        if (n < 4) return 1;
        S[0] = 1;
        S[1] = 2;
        S[2] = 2;
        int p1 = 3;
        int p2 = 2;
        int count = 1;
        boolean change = true;
        while (p1 < n) {
            if (change) S[p1] = S[p1 - 1] == 1 ? 2 : 1;
            else S[p1] = S[p1 - 1];
            if (S[p1++] == 1) count++;
            S[p2]--;
            if (S[p2] == 0) {
                change = true;
                p2++;
            } else {
                change = false;
            }
        }
        return count;
    }
}
