package com.leetcode;

import com.leetcode.service.BiSolution;
import com.leetcode.service.Solution;
import com.leetcode.service.dp.CheckSubarraySum;
import com.leetcode.service.dp.PredictTheWinner;

public class Main {

    public static void main(String[] args) {
        Solution<int[], Boolean> solution = new PredictTheWinner();
        int[] nums = {1, 3, 1};
        System.out.print(solution.solve(nums));
    }
}
