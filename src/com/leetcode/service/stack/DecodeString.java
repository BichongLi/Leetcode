package com.leetcode.service.stack;

import com.leetcode.service.Solution;

import java.util.Stack;

/**
 * User: BichongLi
 * Date: 8/8/2017
 * Time: 9:24 AM
 */
public class DecodeString implements Solution<String, String> {
    @Override
    public String solve(String s) {
        Stack<Pair> stack = new Stack<>();
        int length = s.length();
        String cur = "";
        for (int i = 0; i < length; i++) {
            if (isDigit(s.charAt(i))) {
                int count = 0;
                while (isDigit(s.charAt(i))) {
                    count = count * 10 + s.charAt(i) - '0';
                    i++;
                }

                if (s.charAt(i) == '[') {
                    stack.push(new Pair(cur, count));
                    cur = "";
                }
            } else if (s.charAt(i) == ']') {
                Pair pair = stack.pop();
                StringBuilder builder = new StringBuilder(pair.s);
                for (int j = 0; j < pair.count; j++) {
                    builder.append(cur);
                }
                cur = builder.toString();
            } else {
                cur = cur.concat(String.valueOf(s.charAt(i)));
            }
        }
        return cur;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private class Pair {
        String s;
        int count;

        Pair(String s, int count) {
            this.s = s;
            this.count = count;
        }
    }
}
