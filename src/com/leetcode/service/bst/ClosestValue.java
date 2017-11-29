package com.leetcode.service.bst;

import com.leetcode.model.TreeNode;
import com.leetcode.service.BiSolution;

public class ClosestValue implements BiSolution<TreeNode, Double, Integer> {
    @Override
    public Integer solve(TreeNode root, Double target) {
        int closest = root.val;
        TreeNode tmp = root;
        while (tmp != null) {
            double curDiff = ((double) tmp.val) - target;
            if (curDiff < 1e-8 && curDiff > -1e-8) return tmp.val;
            double preDiff = ((double) closest) - target;
            if (preDiff * preDiff > curDiff * curDiff) {
                closest = tmp.val;
            }
            if (curDiff > 0) tmp = tmp.left;
            else tmp = tmp.right;
        }
        return closest;
    }

}
