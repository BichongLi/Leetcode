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
        int dp[] = new int[s.length()];
        Map<Character, List<Integer>> dict = new HashMap<Character, List<Integer>>();
        dp[0] = 1;
        List<Integer> indexes = new ArrayList<Integer>();
        indexes.add(0);
        dict.put(s.charAt(0), indexes);

        for (int i = 1; i < s.length(); i++) {
            dp[i] = dp[i - 1] + 1;
            if (dict.containsKey(s.charAt(i))) {
                indexes = dict.get(s.charAt(i));
                for (Integer index : indexes) {
                    dp[i] = isPalindrome(s, index, i) ? dp[i] + 1 : dp[i];
                }
            } else {
                indexes = new ArrayList<Integer>();
            }
            indexes.add(i);
            dict.put(s.charAt(i), indexes);
        }
        return dp[s.length() - 1];
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
