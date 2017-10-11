package com.leetcode.service.math;

import com.leetcode.service.Solution;

/**
 * @author bichongli on 10/11/2017
 */
public class LastRemaining implements Solution<Integer, Integer> {
    @Override
    public Integer solve(Integer n) {
        int head = 1;
        boolean left = true;
        int step = 1;
        while (n > 1) {
            if (left || (n & 1) == 1) head += step;
            left = !left;
            step *= 2;
            n /= 2;
        }
        return head;
    }
}
