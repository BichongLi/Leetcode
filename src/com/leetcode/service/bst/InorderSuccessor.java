package com.leetcode.service.bst;

import com.leetcode.model.TreeNode;
import com.leetcode.service.BiSolution;

public class InorderSuccessor implements BiSolution<TreeNode, TreeNode, TreeNode> {
    @Override
    public TreeNode solve(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        TreeNode successor = null;
        while (root != null) {
            if (root.val <= p.val) root = root.right;
            else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
}
