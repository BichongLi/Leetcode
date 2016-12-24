package com.leetcode;

import com.leetcode.model.TreeNode;
import com.leetcode.service.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution<TreeNode, List<Integer>> solution = new InorderTraversal();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> result = solution.solve(root);
        result.forEach(System.out::println);
    }
}
