package com.leetcode.service.dp;

import com.leetcode.service.Solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * User: BichongLi
 * Date: 7/27/2017
 * Time: 9:50 AM
 */
public class FindLongestChain implements Solution<int[][], Integer> {
    @Override
    public Integer solve(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int max = 1;
        int lowest = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > lowest) {
                lowest = pairs[i][1];
                max++;
            }
        }
        return max;
    }
}
