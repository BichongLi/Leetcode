package com.leetcode.service;

public class CheckInclusion implements BiSolution<String, String, Boolean> {
    @Override
    public Boolean solve(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        int lo = 0, hi = s1.length() - 1;
        while (hi < s2.length()) {
            if (checkAllZero(count)) return true;
            if (hi == s2.length() - 1) break;
            count[s2.charAt(lo) - 'a']++;
            count[s2.charAt(hi + 1) - 'a']--;
            lo++;
            hi++;
        }
        return false;
    }

    private boolean checkAllZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}
