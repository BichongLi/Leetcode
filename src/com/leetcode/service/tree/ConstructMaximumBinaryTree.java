package com.leetcode.service.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.service.Solution;

/**
 * @author bichongli on 9/19/2017
 */
public class ConstructMaximumBinaryTree implements Solution<int[], TreeNode> {
    @Override
    public TreeNode solve(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int n = nums.length;
        return buildTree(0, n - 1, nums);
    }

    private TreeNode buildTree(int left, int right, int[] nums) {
        if (left > right) return null;
        int maxIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }
        TreeNode cur = new TreeNode(nums[maxIndex]);
        cur.left = buildTree(left, maxIndex - 1, nums);
        cur.right = buildTree(maxIndex + 1, right, nums);
        return cur;
    }
}
