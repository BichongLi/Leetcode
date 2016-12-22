package com.leetcode;

import com.leetcode.service.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        BiSolution<int[], Integer, List<Integer>> solution = new TopKFrequent();
        List<Integer> result = solution.solve(new int[]{5,-3,9,1,7,7,9,10,2,2,10,10,3,-1,3,7,-9,-1,3,3}, 3);
        result.forEach(System.out::println);
    }
}
