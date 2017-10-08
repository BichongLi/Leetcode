package com.leetcode.service;

public class FlipLights implements BiSolution<Integer, Integer, Integer> {
    @Override
    public Integer solve(Integer n, Integer m) {
        if (m == 0 || n == 0) return 1;
        if (n == 1) return 2;
        if (n == 2) return m == 1 ? 3 : 4;
        if (m == 1) return 4;
        return m == 2 ? 7 : 8;
    }
}
