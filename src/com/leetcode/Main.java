package com.leetcode;

import com.leetcode.service.*;
import com.leetcode.service.bst.ContainsNearbyAlmostDuplicate;
import com.leetcode.service.dp.CountSubstrings;
import com.leetcode.service.dp.FindPaths;
import com.leetcode.service.dp.GetMoneyAmount;
import com.leetcode.service.stack.RemoveKdigits;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TriSolution<int[], Integer, Integer, Boolean> solution = new ContainsNearbyAlmostDuplicate();
        System.out.println(solution.solve(new int[]{0, 2147483647}, 1, 2147483647));
    }
}
