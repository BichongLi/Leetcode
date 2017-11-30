package com.leetcode.service.greedy;

import com.leetcode.service.Solution;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots implements Solution<int[][], Integer> {
    @Override
    public Integer solve(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(p -> p[1]));
        int count = 1, cur = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > cur) {
                count++;
                cur = points[i][1];
            }
        }
        return count;
    }
}
