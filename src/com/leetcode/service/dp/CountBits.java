package com.leetcode.service.dp;

import com.leetcode.service.Solution;

public class CountBits implements Solution<Integer, int[]> {
    @Override
    public int[] solve(Integer num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        for (int i = 1; i <= num; i++) {
            int rightOneCount = rightOneCount(i - 1);
            res[i] = res[i - 1] - rightOneCount + 1;
        }
        return res;
    }

    private int rightOneCount(int num) {
        int count = 0;
        while ((num & 1) != 0) {
            count++;
            num = num >> 1;
        }
        return count;
    }
}
