package com.leetcode.service;

public class StrStr implements BiSolution<String, String, Integer> {
    @Override
    public Integer solve(String haystack, String needle) {
        if (haystack == null || needle == null
                || haystack.length() < needle.length()) return -1;
        if (needle.length() == 0) return 0;
        int i, j = 0;
        for (i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == needle.length() - 1) return i - j;
                j++;
            } else {
                i -= j;
                j = 0;
            }
        }
        return -1;
    }
}
