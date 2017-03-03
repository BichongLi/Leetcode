package com.leetcode.service;

/**
 * User: BichongLi
 * Date: 3/3/2017
 * Time: 7:31 PM
 */
public class FindPoisonedDuration implements BiSolution<int[], Integer, Integer> {
    @Override
    public Integer solve(int[] timeSeries, Integer duration) {
        int total = 0;
        int last = -1;
        for (int i = 0; i < timeSeries.length; i++) {
            if (timeSeries[i] <= last) {
                total += timeSeries[i] + duration - 1 - last;
            } else {
                total += duration;
            }
            last = timeSeries[i] + duration - 1;
        }
        return total;
    }
}
