package com.leetcode.service;

public class TitleToNumber implements Solution<String, Integer> {
    @Override
    public Integer solve(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }
}
