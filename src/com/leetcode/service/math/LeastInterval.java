package com.leetcode.service.math;

import com.leetcode.service.BiSolution;

import java.util.Arrays;

/**
 * @author bichongli on 10/10/2017
 */
public class LeastInterval implements BiSolution<char[], Integer, Integer> {
    @Override
    public Integer solve(char[] tasks, Integer n) {
        if (n == 0) return tasks.length;
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        Arrays.sort(count);
        int largest = count[25];
        int i = 24;
        while (i >= 0 && count[i] == largest) i--;
        return Math.max((largest - 1) * (n + 1) + 25 - i, tasks.length);
    }
}
