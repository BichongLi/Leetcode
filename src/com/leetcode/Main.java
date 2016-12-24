package com.leetcode;

import com.leetcode.model.TreeNode;
import com.leetcode.service.*;
import com.leetcode.service.tree.InorderTraversal;
import com.leetcode.service.tree.PostorderTraversal;
import com.leetcode.service.tree.PreorderTraversal;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution<TreeNode, List<Integer>> solution = new PostorderTraversal();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> result = solution.solve(root);
        result.forEach(System.out::println);
    }
}
