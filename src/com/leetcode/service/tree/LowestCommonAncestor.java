package com.leetcode.service.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.service.TriSolution;

public class LowestCommonAncestor implements TriSolution<TreeNode, TreeNode, TreeNode, TreeNode> {
    @Override
    public TreeNode solve(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        if (root == p || root == q) return root;
        TreeNode leftSub = solve(root.left, p, q);
        TreeNode rightSub = solve(root.right, p, q);
        if (leftSub == null && rightSub == null) return null;
        if (leftSub != null && rightSub != null) return root;
        return leftSub == null ? rightSub : leftSub;
    }
}
