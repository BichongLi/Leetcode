package com.leetcode.service.dp;

import com.leetcode.service.Solution;

/**
 * User: BichongLi
 * Date: 3/24/2017
 * Time: 10:16 AM
 */
public class LongestPalindromeSubseq implements Solution<String, Integer> {
    @Override
    public Integer solve(String s) {
        int[][] l = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            l[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j == i + 1) l[i][j] = 2;
                    else l[i][j] = l[i + 1][j - 1] + 2;
                } else {
                    l[i][j] = Math.max(l[i + 1][j], l[i][j - 1]);
                }
            }
        }
        return l[0][s.length() - 1];
    }
}
