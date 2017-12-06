package com.leetcode.service.dp;

import com.leetcode.service.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: BichongLi
 * Date: 7/26/2017
 * Time: 10:23 AM
 */
public class CountSubstrings implements Solution<String, Integer> {
    @Override
    public Integer solve(String s) {
        if (s == null || s.length() == 0) return 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int count = s.length();
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = s.length() - 1; j > i; j--) {
                if (s.charAt(i) == s.charAt(j) &&
                        (j == i + 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
