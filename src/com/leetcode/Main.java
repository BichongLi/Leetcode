package com.leetcode;

import com.leetcode.service.Solution;
import com.leetcode.service.math.SingleNumber;

public class Main {

    public static void main(String[] args) {
        Solution<int[], Integer> solution = new SingleNumber();
        solution.solve(new int[]{1, 3, 1, 1});
    }
}
