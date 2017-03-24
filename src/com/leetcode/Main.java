package com.leetcode;

import com.leetcode.service.BiSolution;
import com.leetcode.service.dp.CheckSubarraySum;

public class Main {

    public static void main(String[] args) {
        BiSolution<int[], Integer, Boolean> solution = new CheckSubarraySum();
        int[] nums = {23, 2, 4, 6, 7};
        System.out.print(solution.solve(nums, 6));
    }
}
