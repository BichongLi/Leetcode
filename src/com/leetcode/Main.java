package com.leetcode;

import com.leetcode.service.BiSolution;
import com.leetcode.service.CheckInclusion;
import com.leetcode.service.ReverseWords;
import com.leetcode.service.Solution;
import com.leetcode.service.binarysearch.Search33;
import com.leetcode.service.math.MaximumSwap;

public class Main {

    public static void main(String[] args) {
        BiSolution<String, String, Boolean> solution = new CheckInclusion();
        solution.solve("adc", "dcda");
    }
}
