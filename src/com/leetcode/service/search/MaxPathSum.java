package com.leetcode.service.search;

import com.leetcode.model.TreeNode;
import com.leetcode.service.Solution;

public class MaxPathSum implements Solution<TreeNode, Integer> {

    private int max;

    @Override
    public Integer solve(TreeNode root) {
        if (root == null) return 0;
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = getMax(max, root.val, root.val + left, root.val + right, root.val + left + right);
        return getMax(root.val, root.val + left, root.val + right);
    }

    private int getMax(int ... nums) {
        int maxNum = Integer.MIN_VALUE;
        for (int num : nums) {
            maxNum = Math.max(num, maxNum);
        }
        return maxNum;
    }
}
