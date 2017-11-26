package com.leetcode.service.dp;

import com.leetcode.service.Solution;

public class LongestPalindrome implements Solution<String, String> {
    @Override
    public String solve(String s) {
        if (s == null) return null;
        if (s.length() == 1) return s;
        char[] str = s.toCharArray();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int max = 0;
        int[] range = new int[2];
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (i + 1 == j) dp[i][j] = str[i] == str[j];
                else dp[i][j] = dp[i + 1][j - 1] && str[i] == str[j];
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    range[0] = i;
                    range[1] = j;
                }
            }
        }
        return s.substring(range[0], range[1] + 1);
    }
}
