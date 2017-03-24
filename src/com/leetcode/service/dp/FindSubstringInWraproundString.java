package com.leetcode.service.dp;

import com.leetcode.service.Solution;

/**
 * User: BichongLi
 * Date: 3/24/2017
 * Time: 4:14 PM
 */
public class FindSubstringInWraproundString implements Solution<String, Integer> {
    @Override
    public Integer solve(String p) {
        if (p == null || p.length() == 0) return 0;
        int[] dp = new int[p.length()];
        boolean[] flag = new boolean[26];
        dp[p.length() - 1] = 1;
        char right = p.charAt(p.length() - 1);
        for (int i = p.length() - 2; i >= 0; i--) {
            if (charsTogether(p.charAt(i), p.charAt(i + 1))) {

            } else {
                dp[i] = 1 + dp[i + 1];
                start[i] = 1;
            }
        }
        return dp[0];
    }

    private boolean charsTogether(char c1, char c2) {
        return (c1 == 'z' && c2 == 'a' || c1 + 1 == c2);
    }
}
