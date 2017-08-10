package com.leetcode.service.stack;

import com.leetcode.service.BiSolution;

import java.util.Stack;

/**
 * User: BichongLi
 * Date: 8/9/2017
 * Time: 9:33 PM
 */
public class RemoveKdigits implements BiSolution<String, Integer, String> {
    @Override
    public String solve(String num, Integer k) {
        if (k >= num.length()) return "0";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char digit = num.charAt(i);
            while (k > 0 && !stack.isEmpty() && digit < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        builder.reverse();
        String res = null;
        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) != '0') {
                res = builder.substring(i);
                break;
            }
        }
        if (res == null) return "0";
        return res;
    }
}
