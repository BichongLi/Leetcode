package com.leetcode;

import com.leetcode.service.*;
import com.leetcode.service.backtracking.CombinationSum;
import com.leetcode.service.backtracking.Subsets;
import com.leetcode.service.bst.ContainsNearbyAlmostDuplicate;
import com.leetcode.service.dp.CountSubstrings;
import com.leetcode.service.dp.FindPaths;
import com.leetcode.service.dp.GetMoneyAmount;
import com.leetcode.service.dp.IntegerBreak;
import com.leetcode.service.heap.FindKthLargest;
import com.leetcode.service.stack.RemoveKdigits;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        BiSolution<int[], Integer, List<List<Integer>>> solution = new CombinationSum();
        solution.solve(new int[]{8, 7, 4, 3}, 11);
    }
}
