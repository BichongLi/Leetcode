package com.leetcode.service.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.service.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * User: BichongLi
 * Date: 3/2/2017
 * Time: 3:13 PM
 */
public class LargestValues implements Solution<TreeNode, List<Integer>> {
    @Override
    public List<Integer> solve(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        List<TreeNode> curLevel = new ArrayList<>();
        List<TreeNode> nextLevel = new ArrayList<>();
        curLevel.add(root);
        result.add(root.val);
        while (!curLevel.isEmpty()) {
            int max = Integer.MIN_VALUE;
            for (TreeNode node : curLevel) {
                if (node.left != null) {
                    nextLevel.add(node.left);
                    max = max < node.left.val ? node.left.val : max;
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                    max = max < node.right.val ? node.right.val : max;
                }
            }
            if (!nextLevel.isEmpty()) result.add(max);
            curLevel.clear();
            curLevel.addAll(nextLevel);
            nextLevel.clear();
        }
        return result;
    }
}
