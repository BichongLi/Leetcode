package com.leetcode.service.dp;

import com.leetcode.Main;
import com.leetcode.service.Solution;

import java.util.List;

/**
 * User: BichongLi
 * Date: 3/25/2017
 * Time: 7:15 PM
 */
public class MinimumTotal implements Solution<List<List<Integer>>, Integer> {
    @Override
    public Integer solve(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for (List<Integer> level : triangle) {
            if (level.size() == 1) continue;
            int index = 0;
            for (Integer num : level) {
                if (index == 0) {
                    dp[level.size() - 1][index] = dp[level.size() - 2][index] + num;
                } else if (index == level.size() - 1) {
                    dp[level.size() - 1][index] = dp[level.size() - 2][index - 1] + num;
                } else {
                    dp[level.size() - 1][index] = Math.min(dp[level.size() - 2][index - 1] + num,
                            dp[level.size() - 2][index] + num);
                }
                index++;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++) {
            min = min < dp[triangle.size() - 1][i] ? min : dp[triangle.size() - 1][i];
        }
        return min;
    }
}
