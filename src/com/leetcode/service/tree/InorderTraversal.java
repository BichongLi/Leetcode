package com.leetcode.service.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.service.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * User: BichongLi
 * Date: 12/24/2016
 * Time: 3:12 PM
 */
public class InorderTraversal implements Solution<TreeNode, List<Integer>> {
    @Override
    public List<Integer> solve(TreeNode root) {
        return nonRecursive(root);
    }

    private void dfs(TreeNode root, List<Integer> result) {
        if (root == null) return;
        dfs(root.left, result);
        result.add(root.val);
        dfs(root.right, result);
    }

    private List<Integer> nonRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }
}
