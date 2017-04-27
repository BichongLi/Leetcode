package com.leetcode;

import com.leetcode.service.DiffWaysToCompute;
import com.leetcode.service.Solution;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution<String, List<Integer>> solution = new DiffWaysToCompute();
        System.out.println(solution.solve("2-1-1"));
    }
}
