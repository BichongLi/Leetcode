package com.leetcode;

import com.leetcode.service.*;

public class Main {

    public static void main(String[] args) {
        Solution<int[], Integer> solution = new MinMoves2();
        int[] series = {3, 2, 1};
        System.out.println(solution.solve(series));
    }
}
