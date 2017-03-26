package com.leetcode.service.dp;

import com.leetcode.service.Solution;

import java.util.HashSet;
import java.util.Set;

/**
 * User: BichongLi
 * Date: 3/25/2017
 * Time: 1:53 PM
 */
public class NumDecodings implements Solution<String, Integer> {

    @Override
    public Integer solve(String s) {
        if (s == null || s.equals("")) return 0;
        int[] dp = new int[s.length()];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            if (valid(String.valueOf(s.charAt(i)))) {
                if (valid(s.substring(i - 1, i + 1))) {
                    if (i == 1) dp[i] = dp[i - 1] + 1;
                    else dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            } else {
                if (valid(s.substring(i - 1, i + 1))) {
                    if (i == 1) dp[i] = 1;
                    else dp[i] = dp[i - 2];
                } else {
                    dp[i] = 0;
                }
            }
        }
        return dp[s.length() - 1];
    }

    private boolean valid(String s) {
        if (s.length() > 2 || s.length() < 1) return false;
        if (s.length() == 1) {
            return s.charAt(0) >= '1' && s.charAt(0) <= '9';
        } else {
            return (s.charAt(0) >= '1' && s.charAt(0) <= '9' &&
                    Integer.valueOf(s) >= 1 && Integer.valueOf(s) <= 26);
        }
    }
}
