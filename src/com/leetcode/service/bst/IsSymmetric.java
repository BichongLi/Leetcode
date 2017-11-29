package com.leetcode.service.bst;

import com.leetcode.model.TreeNode;
import com.leetcode.service.Solution;

public class IsSymmetric implements Solution<TreeNode, Boolean> {
    @Override
    public Boolean solve(TreeNode root) {
        return root == null || dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        return p.val == q.val && dfs(p.left, q.right) && dfs(p.right, q.left);
    }
}
