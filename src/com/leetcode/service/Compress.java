package com.leetcode.service;

public class Compress implements Solution<char[], Integer> {
    @Override
    public Integer solve(char[] chars) {
        char c = chars[0];
        int count = 1;
        int p = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                chars[p++] = c;
                if (count > 1) {
                    String countStr = Integer.valueOf(count).toString();
                    for (int j = 0; j < countStr.length(); j++) {
                        chars[p++] = countStr.charAt(j);
                    }
                }
                c = chars[i];
                count = 1;
            }
        }
        chars[p++] = c;
        if (count > 1) {
            String countStr = Integer.valueOf(count).toString();
            for (int j = 0; j < countStr.length(); j++) {
                chars[p++] = countStr.charAt(j);
            }
        }
        return p;
    }
}
