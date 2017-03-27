package com.leetcode;

import com.leetcode.service.BiSolution;
import com.leetcode.service.Solution;
import com.leetcode.service.dp.IntegerBreak;
import com.leetcode.service.dp.NthUglyNumber;
import com.leetcode.service.dp.WiggleMaxLength;
import com.leetcode.service.dp.WordBreak;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution<Integer, Integer> solution = new NthUglyNumber();
        System.out.println(solution.solve(37));
    }
}
