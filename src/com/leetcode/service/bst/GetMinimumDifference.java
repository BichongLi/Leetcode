package com.leetcode.service.bst;

import com.leetcode.model.TreeNode;
import com.leetcode.service.Solution;

/**
 * User: BichongLi
 * Date: 8/15/2017
 * Time: 9:33 AM
 */
public class GetMinimumDifference implements Solution<TreeNode, Integer> {

    private int min = Integer.MAX_VALUE;
    private int pre;
    private boolean preSet = false;

    @Override
    public Integer solve(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return 0;
        dfs(root);
        return min;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);

        if (!preSet) {
            preSet = true;
        } else {
            int diff = node.val - pre;
            min = min < diff ? min : diff;
        }
        pre = node.val;

        dfs(node.right);
    }
}
