package com.leetcode.service.tree;

import com.leetcode.model.TreeLinkNode;
import com.leetcode.service.Solution;

/**
 * @author bichongli on 9/21/2017
 */
public class Connect implements Solution<TreeLinkNode, Void> {
    @Override
    public Void solve(TreeLinkNode root) {
        if (root == null) return null;
        dfs(root);
        return null;
    }

    private void dfs(TreeLinkNode root) {
        if (root == null || root.left == null) return;
        TreeLinkNode left = root.left;
        TreeLinkNode right = root.right;
        while (left != null && right != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        dfs(root.left);
        dfs(root.right);
    }
}
