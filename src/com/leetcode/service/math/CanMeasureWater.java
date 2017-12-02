package com.leetcode.service.math;

import com.leetcode.service.TriSolution;

import java.util.HashSet;
import java.util.Set;

public class CanMeasureWater implements TriSolution<Integer, Integer, Integer, Boolean> {

    @Override
    public Boolean solve(Integer x, Integer y, Integer z) {
        if (x == z || y == z || x + y == z) return true;
        if (x + y < z) return false;
        return z % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {
        while (a != 0 && b != 0 && a != b) {
            if (a > b) a = a - b;
            else b = b - a;
        }
        if (a == b) return a;
        return a == 0 ? b : a;
    }
}
