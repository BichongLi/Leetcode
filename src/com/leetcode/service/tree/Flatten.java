package com.leetcode.service.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.service.Solution;

/**
 * @author bichongli on 9/22/2017
 */
public class Flatten implements Solution<TreeNode, Void> {
    @Override
    public Void solve(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        return null;
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode leftSub = dfs(root.left);
        TreeNode rightSub = dfs(root.right);
        if (leftSub != null) {
            leftSub.right = root.right;
            root.right = root.left;
        }
        root.left = null;
        if (rightSub == null) return leftSub;
        return rightSub;
    }
}
