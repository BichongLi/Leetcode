package com.leetcode;

import com.leetcode.service.BiSolution;
import com.leetcode.service.ReverseWords;
import com.leetcode.service.Solution;
import com.leetcode.service.binarysearch.Search33;
import com.leetcode.service.math.MaximumSwap;

public class Main {

    public static void main(String[] args) {
        BiSolution<int[], Integer, Integer> solution = new Search33();
        solution.solve(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
    }
}
