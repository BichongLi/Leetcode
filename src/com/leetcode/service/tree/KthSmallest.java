package com.leetcode.service.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.service.BiSolution;

/**
 * User: BichongLi
 * Date: 3/4/2017
 * Time: 3:34 PM
 */
public class KthSmallest implements BiSolution<TreeNode, Integer, Integer> {

    private int count;
    private int val;
    private boolean found;

    @Override
    public Integer solve(TreeNode root, Integer k) {
        count = 0;
        found = false;
        inOrder(root, k);
        return val;
    }

    private void inOrder(TreeNode root, int k) {
        if (found) return;
        if (root.left != null) inOrder(root.left, k);
        count ++;
        if (count == k) {
            val = root.val;
            found = true;
            return;
        }
        if (root.right != null) inOrder(root.right, k);
    }
}
