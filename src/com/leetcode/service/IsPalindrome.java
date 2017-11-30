package com.leetcode.service;

public class IsPalindrome implements Solution<String, Boolean> {
    @Override
    public Boolean solve(String s) {
        s = parse(s);
        if (s == null || s.length() == 0) return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    private String parse(String s) {
        if (s == null || s.length() == 0) return null;
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') c -= ('A' - 'a');
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) sb.append(c);
        }
        return sb.toString();
    }
}
