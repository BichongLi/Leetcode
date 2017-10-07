package com.leetcode.service.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.service.Solution;

public class IsValidBST implements Solution<TreeNode, Boolean> {

    private Integer last;
    private boolean flag;

    @Override
    public Boolean solve(TreeNode root) {
        if (root == null) return true;
        last = null;
        flag = true;
        dfs(root);
        return flag;
    }

    private void dfs(TreeNode root) {
        if (root == null || !flag) return;
        dfs(root.left);
        if (last != null && root.val <= last) {
            flag = false;
            return;
        }
        last = root.val;
        dfs(root.right);
    }
}
