package com.leetcode.service.math;

import com.leetcode.service.Solution;

/**
 * @author bichongli on 10/18/2017
 */
public class MaximumSwap implements Solution<Integer, Integer> {
    @Override
    public Integer solve(Integer num) {
        if (num <= 11) return num;
        String s = String.valueOf(num);
        int[] digits = new int[10];
        int[] pos = new int[10];
        for (int i = 0; i < 10; i++) pos[i] = -1;
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            digits[i] = digit;
            pos[digit] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 9; j > digits[i]; j--) {
                if (pos[j] != -1 && pos[j] > i) {
                    int tmp = digits[i];
                    digits[i] = j;
                    digits[pos[j]] = tmp;
                    int res = 0;
                    for (int k = 0; k < s.length(); k++) {
                        res = res * 10 + digits[k];
                    }
                    return res;
                }
            }
        }
        return num;
    }
}
