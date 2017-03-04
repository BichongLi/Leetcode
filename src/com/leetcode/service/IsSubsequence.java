package com.leetcode.service;

/**
 * User: BichongLi
 * Date: 3/4/2017
 * Time: 10:39 AM
 */
public class IsSubsequence implements BiSolution<String, String, Boolean> {
    @Override
    public Boolean solve(String s, String t) {
        if (s == null || s.length() == 0) return true;
        if (t == null || t.length() == 0) return false;
        int i = 0;
        int j = 0;
        while (j < t.length() && i < s.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i >= s.length();
    }
}
