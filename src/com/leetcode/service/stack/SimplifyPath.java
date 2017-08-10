package com.leetcode.service.stack;

import com.leetcode.service.Solution;

import java.util.Stack;

/**
 * User: BichongLi
 * Date: 8/10/2017
 * Time: 9:40 AM
 */
public class SimplifyPath implements Solution<String, String> {
    @Override
    public String solve(String path) {
        String[] parts = path.split("/");
        String[] stack = new String[parts.length];
        int top = 0;
        for (String part : parts) {
            if (part.equals("") || part.equals(".")) continue;
            if (part.equals("..")) {
                if (top > 0) top--;
            } else {
                stack[top++] = part;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < top; i++) {
            builder.append("/").append(stack[i]);
        }
        if (builder.length() == 0) builder.append("/");
        return builder.toString();
    }
}
