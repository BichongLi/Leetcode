package com.leetcode.service.backtracking;

import com.leetcode.service.BiSolution;

/**
 * @author bichongli on 8/22/2017
 */
public class GetPermutation implements BiSolution<Integer, Integer, String> {

    private static int[] s = new int[10];

    static {
        s[0] = 1;
        for (int i = 1; i < 10; i++) {
            s[i] = s[i - 1] * i;
        }
    }

    @Override
    public String solve(Integer n, Integer k) {
        boolean[] used = new boolean[10];
        StringBuilder builder = new StringBuilder();
        int idx;
        for (int i = n; i > 0; i--) {
            if (k % s[i - 1] == 0) idx = k / s[i - 1];
            else idx = k / s[i - 1] + 1;
            k -= (idx - 1) * s[i - 1];
            for (int j = 1; j <= n; j++) {
                if (!used[j]) {
                    idx--;
                    if (idx == 0) {
                        builder.append(j);
                        used[j] = true;
                        break;
                    }
                }
            }
        }
        return builder.toString();
    }
}
