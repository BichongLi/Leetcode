package com.leetcode.service.dp;

import com.leetcode.service.BiSolution;

import java.util.List;

/**
 * User: BichongLi
 * Date: 3/26/2017
 * Time: 9:22 AM
 */
public class WordBreak implements BiSolution<String, List<String>, Boolean> {

    @Override
    public Boolean solve(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                dp[i] = s.substring(0, i).equals(word) ||
                        (s.substring(0, i).endsWith(word) && dp[i - word.length()]);
                if (dp[i]) break;
            }
        }
        return dp[s.length()];
    }

}
