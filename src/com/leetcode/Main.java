package com.leetcode;

import com.leetcode.model.ListNode;
import com.leetcode.service.AddTwoNumbers;
import com.leetcode.service.BiSolution;
import com.leetcode.service.OptimalDivision;
import com.leetcode.service.Solution;
import com.leetcode.service.dp.IntegerBreak;
import com.leetcode.service.dp.NthUglyNumber;
import com.leetcode.service.dp.WiggleMaxLength;
import com.leetcode.service.dp.WordBreak;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution<int[], String> solution = new OptimalDivision();
        System.out.print(solution.solve(new int[]{100, 10, 5}));
    }
}
