package com.leetcode.service.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.service.Solution;

/**
 * User: BichongLi
 * Date: 3/2/2017
 * Time: 2:49 PM
 */
public class FindBottomLeftValue implements Solution<TreeNode, Integer> {

    private int maxDepth = 0;
    private TreeNode bottomLeft;

    @Override
    public Integer solve(TreeNode root) {
        if (root == null) return 0;
        bottomLeft = root;
        dfs(root, 0);
        return bottomLeft.val;
    }

    private void dfs(TreeNode root, int depth) {
        if (root.left != null) {
            if (depth + 1 > maxDepth) {
                maxDepth = depth + 1;
                bottomLeft = root.left;
            }
            dfs(root.left, depth + 1);
        }
        if (root.right != null) {
            if (depth + 1 > maxDepth) {
                maxDepth = depth + 1;
                bottomLeft = root.right;
            }
            dfs(root.right, depth + 1);
        }
    }
}
