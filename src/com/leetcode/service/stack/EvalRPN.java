package com.leetcode.service.stack;

import com.leetcode.service.Solution;

import java.util.Stack;

/**
 * User: BichongLi
 * Date: 8/9/2017
 * Time: 9:34 AM
 */
public class EvalRPN implements Solution<String[], Integer> {
    @Override
    public Integer solve(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int a, b;
        for (String token : tokens) {
            if (!isOperator(token)) stack.push(Integer.valueOf(token));
            else {
                b = stack.pop();
                a = stack.pop();
                stack.push(calculate(a, b, token));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int calculate(int a, int b, String operator) {
        if (operator.equals("+")) return a + b;
        if (operator.equals("-")) return a - b;
        if (operator.equals("*")) return a * b;
        if (operator.equals("/")) return a / b;
        return 0;
    }
}
