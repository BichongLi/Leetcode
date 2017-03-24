package com.leetcode.service.dp;

import com.leetcode.service.TriSolution;

/**
 * User: BichongLi
 * Date: 3/24/2017
 * Time: 3:30 PM
 */
public class FindMaxForm implements TriSolution<String[], Integer, Integer, Integer> {
    @Override
    public Integer solve(String[] strs, Integer m, Integer n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            int[] count = count(strs[i]);
            for (int j = m; j >= count[0]; j--) {
                for (int k = n; k >= count[1]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - count[0]][k - count[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] count(String s) {
        int[] count = new int[2];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - '0']++;
        }
        return count;
    }
}
