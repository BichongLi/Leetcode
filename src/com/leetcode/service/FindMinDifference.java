package com.leetcode.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: BichongLi
 * Date: 4/21/2017
 * Time: 12:23 PM
 */
public class FindMinDifference implements Solution<List<String>, Integer> {

    private int[] timeBucket = new int[24 * 60];

    @Override
    public Integer solve(List<String> timePoints) {
        Arrays.fill(timeBucket, 0);
        for (String time : timePoints) {
            String[] t = time.split(":");
            int minutes = Integer.valueOf(t[0]) * 60 + Integer.valueOf(t[1]);
            timeBucket[minutes]++;
        }
        int minDiff = Integer.MAX_VALUE;
        int pre = -1;
        int first = 0;
        for (int i = 0; i < 24 * 60; i++) {
            if (timeBucket[i] > 1) return 0;
            if (timeBucket[i] == 1) {
                if (pre != -1) {
                    int diff = i - pre;
                    minDiff = minDiff < diff ? minDiff : diff;
                } else {
                    first = i;
                }
                pre = i;
            }
        }
        int lastAndFirst = 24 * 60 - pre + first;
        return minDiff < lastAndFirst ? minDiff : lastAndFirst;
    }
}
