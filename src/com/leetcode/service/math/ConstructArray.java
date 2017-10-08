package com.leetcode.service.math;

import com.leetcode.service.BiSolution;

public class ConstructArray implements BiSolution<Integer, Integer, int[]> {
    @Override
    public int[] solve(Integer n, Integer k) {
        int[] res = new int[n];
        int head = 1, tail = n;
        for (int i = 0; i < n; i++) {
            res[i] = k > 1 ? ((k-- & 1) == 1 ? head++ : tail--) : head++;
        }
        return res;
    }
}
