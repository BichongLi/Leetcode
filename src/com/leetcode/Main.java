package com.leetcode;

import com.leetcode.service.ArithmeticSlices;
import com.leetcode.service.CountingBits;
import com.leetcode.service.Solution;

public class Main {

    public static void main(String[] args) {
        Solution<int[], Integer> solution = new ArithmeticSlices();
        System.out.println(solution.solve(new int[] {1,2,3,8,9,10}));
    }
}
