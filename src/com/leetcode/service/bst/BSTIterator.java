package com.leetcode.service.bst;

import com.leetcode.model.TreeNode;

import java.util.Stack;

/**
 * @author bichongli on 11/28/2017
 */
public class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode smallest = stack.pop();
        TreeNode tmp = smallest.right;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.left;
        }
        return smallest.val;
    }

}
