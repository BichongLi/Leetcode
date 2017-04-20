package com.leetcode.service;

/**
 * User: BichongLi
 * Date: 4/2/2017
 * Time: 6:35 PM
 */
public class ComplexNumberMultiply implements BiSolution<String, String, String> {
    @Override
    public String solve(String a, String b) {
        int[] params1 = parse(a);
        int[] params2 = parse(b);
        return String.format("%1$d+%2$di", params1[0] * params2[0] - params1[1] * params2[1],
                params1[0] * params2[1] + params2[0] * params1[1]);
    }

    private int[] parse(String s) {
        String[] parts = s.split("\\+");
        int[] params = new int[2];
        params[0] = Integer.valueOf(parts[0]);
        params[1] = Integer.valueOf(parts[1].substring(0, parts[1].length() - 1));
        return params;
    }
}
