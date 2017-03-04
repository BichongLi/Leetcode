package com.leetcode;

import com.leetcode.model.TreeNode;
import com.leetcode.service.*;
import com.leetcode.service.tree.KthSmallest;

public class Main {

    public static void main(String[] args) {
        BiSolution<TreeNode, Integer, Integer> solution = new KthSmallest();
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        System.out.println(solution.solve(root, 6));
    }
}
