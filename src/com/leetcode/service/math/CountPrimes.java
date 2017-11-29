package com.leetcode.service.math;

import com.leetcode.service.Solution;

public class CountPrimes implements Solution<Integer, Integer> {
    @Override
    public Integer solve(Integer n) {
        if (n <= 2) return 0;
        boolean[] flag = new boolean[n];
        flag[1] = true;
        int count = n - 2;
        for (int i = 2;; i++) {
            int j = i;
            if (i * j >= n) break;
            while (i * j < n) {
                if (!flag[i * j]) {
                    flag[i * j] = true;
                    count--;
                }
                j++;
            }
        }
        return count;
    }
}
