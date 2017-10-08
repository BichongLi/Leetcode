package com.leetcode.service.math;

import com.leetcode.service.Solution;

public class FractionAddition implements Solution<String, String> {
    @Override
    public String solve(String expression) {
        String[] fractions = expression.split("(?=[-+])");
        String res = "0/1";
        for (String fraction : fractions) res = sum(res, fraction);
        return res;
    }

    private String sum(String a, String b) {
        String[] tokenA = a.split("/");
        String[] tokenB = b.split("/");
        int numerator = Integer.valueOf(tokenA[0]) * Integer.valueOf(tokenB[1]) +
                Integer.valueOf(tokenB[0]) * Integer.valueOf(tokenA[1]);
        int denominator = Integer.valueOf(tokenA[1]) * Integer.valueOf(tokenB[1]);
        String sign = "";
        if (numerator < 0) {
            sign = "-";
            numerator = -numerator;
        }
        int gcd = gcd(numerator, denominator);
        return String.format("%1$s%2$d/%3$d", sign, numerator / gcd, denominator / gcd);
    }

    private int gcd(int a, int b) {
        if (a == 0 || b == 0) return a + b;
        return gcd(b, a % b);
    }
}
