package com.leetcode.service;

import java.util.Arrays;

/**
 * User: BichongLi
 * Date: 3/22/2017
 * Time: 8:23 PM
 */
public class FindMinArrowShots implements Solution<int[][], Integer> {
    @Override
    public Integer solve(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, (p1, p2) -> {
            if (p1[0] == p2[0]) return p1[1] - p2[1];
            else return p1[0] - p2[0];
        });
        int count = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                end = end < points[i][1] ? end : points[i][1];
            } else {
                count++;
                end = points[i][1];
            }
        }
        return count;
    }
}
