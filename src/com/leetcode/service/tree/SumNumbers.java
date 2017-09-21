package com.leetcode.service.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.service.Solution;

/**
 * @author bichongli on 9/21/2017
 */
public class SumNumbers implements Solution<TreeNode, Integer> {

    private int sum;

    @Override
    public Integer solve(TreeNode root) {
        if (root == null) return 0;
        sum = 0;
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int num) {
        int tmp = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += tmp;
            return;
        }
        if (root.left != null) dfs(root.left, tmp);
        if (root.right != null) dfs(root.right, tmp);
    }
}
