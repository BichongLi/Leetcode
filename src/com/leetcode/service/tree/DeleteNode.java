package com.leetcode.service.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.service.BiSolution;

/**
 * @author bichongli on 9/20/2017
 */
public class DeleteNode implements BiSolution<TreeNode, Integer, TreeNode> {
    @Override
    public TreeNode solve(TreeNode root, Integer key) {
        if (root == null) return null;
        if (key < root.val) root.left = solve(root.left, key);
        else if (key > root.val) root.right = solve(root.right, key);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            root.val = findMax(root.left);
            root.left = solve(root.left, root.val);
        }
        return root;
    }

    private int findMax(TreeNode root) {
        while (root.right != null) root = root.right;
        return root.val;
    }
}
