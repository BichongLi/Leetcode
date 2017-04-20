package com.leetcode;

import com.leetcode.model.TreeNode;
import com.leetcode.service.BiSolution;
import com.leetcode.service.Solution;
import com.leetcode.service.dp.IntegerBreak;
import com.leetcode.service.dp.NthUglyNumber;
import com.leetcode.service.dp.WiggleMaxLength;
import com.leetcode.service.dp.WordBreak;
import com.leetcode.service.tree.FindFrequentTreeSum;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution<TreeNode, int[]> solution = new FindFrequentTreeSum();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(7);
        solution.solve(root);
    }
}
