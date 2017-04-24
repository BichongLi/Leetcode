package com.leetcode.service;

import com.leetcode.model.TreeNode;

/**
 * User: BichongLi
 * Date: 4/24/2017
 * Time: 8:53 PM
 */
public class Rob implements Solution<TreeNode, Integer> {

    @Override
    public Integer solve(TreeNode root) {
        int[] res = dfs(root);
        return res[0] > res[1] ? res[0] : res[1];
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] res = new int[2];
        res[0] = root.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}
