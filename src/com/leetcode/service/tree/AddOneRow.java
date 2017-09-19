package com.leetcode.service.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.service.TriSolution;

/**
 * @author bichongli on 9/19/2017
 */
public class AddOneRow implements TriSolution<TreeNode, Integer, Integer, TreeNode> {
    @Override
    public TreeNode solve(TreeNode root, Integer v, Integer d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        dfs(root, d, v, 1);
        return root;
    }

    private void dfs(TreeNode root, int d, int v, int cur) {
        if (root == null || cur >= d) return;
        if (cur + 1 == d) {
            TreeNode newLeft = new TreeNode(v);
            TreeNode newRight = new TreeNode(v);
            newLeft.left = root.left;
            newRight.right = root.right;
            root.left = newLeft;
            root.right = newRight;
            return;
        }
        dfs(root.left, d, v, cur + 1);
        dfs(root.right, d, v, cur + 1);
    }
}
