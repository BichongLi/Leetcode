package com.leetcode.service.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.service.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * User: BichongLi
 * Date: 12/24/2016
 * Time: 4:09 PM
 */
public class PreorderTraversal implements Solution<TreeNode, List<Integer>> {
    @Override
    public List<Integer> solve(TreeNode root) {
        return nonRecursion(root);
    }

    private void dfs(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        dfs(root.left, result);
        dfs(root.right, result);
    }

    private List<Integer> nonRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                result.add(current.val);
                stack.add(current);
                current = current.left;
            }
            current = stack.pop().right;
        }
        return result;
    }
}
