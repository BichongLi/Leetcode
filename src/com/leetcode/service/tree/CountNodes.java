package com.leetcode.service.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.service.Solution;

public class CountNodes implements Solution<TreeNode, Integer> {

    @Override
    public Integer solve(TreeNode root) {
        int h = getHeight(root);
        if (h == 0) return 0;
        int rightH = getHeight(root.right);
        if (rightH == h - 1) return (1 << (h - 1)) + solve(root.right);
        return (1 << (h - 2)) + solve(root.left);
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + getHeight(root.left);
    }
}
