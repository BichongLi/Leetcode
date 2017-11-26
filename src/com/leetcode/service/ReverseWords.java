package com.leetcode.service;

public class ReverseWords implements Solution<char[], Void> {
    @Override
    public Void solve(char[] str) {
        if (str == null || str.length < 2) return null;
        reverse(str, 0, str.length - 1);
        int start = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                reverse(str, start, i - 1);
                start = i + 1;
                continue;
            }
            if (i == str.length - 1) {
                reverse(str, start, i);
                break;
            }
        }
        return null;
    }

    private void reverse(char[] s, int start, int end) {
        int i = start, j = end;
        char tmp;
        while (i < j) {
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
}
