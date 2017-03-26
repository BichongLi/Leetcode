package com.leetcode.service.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.service.Solution;

/**
 * User: BichongLi
 * Date: 3/23/2017
 * Time: 11:25 PM
 */
public class ConvertBST implements Solution<TreeNode, TreeNode> {

    private int sum = 0;

    @Override
    public TreeNode solve(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root);
        root.val += sum;
        sum = root.val;
        dfs(root.left);
    }
}
