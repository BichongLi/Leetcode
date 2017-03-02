package com.leetcode;

import com.leetcode.model.TreeNode;
import com.leetcode.service.BiSolution;
import com.leetcode.service.CountArrangement;
import com.leetcode.service.RotateArray;
import com.leetcode.service.Solution;
import com.leetcode.service.tree.FindBottomLeftValue;

public class Main {

    public static void main(String[] args) {
        Solution<Integer, Integer> solution = new CountArrangement();
        System.out.println(solution.solve(15));
    }
}
