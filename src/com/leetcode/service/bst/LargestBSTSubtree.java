package com.leetcode.service.bst;

import com.leetcode.model.TreeNode;
import com.leetcode.service.Solution;

public class LargestBSTSubtree implements Solution<TreeNode, Integer> {

    private int max;

    @Override
    public Integer solve(TreeNode root) {
        if (root == null) return 0;
        max = 0;
        dfs(root);
        return max;
    }

    private Subtree dfs(TreeNode root) {
        if (root == null) return new Subtree(0, 0, 0, true);
        Subtree leftSubtree = dfs(root.left);
        Subtree rightSubtree = dfs(root.right);
        if (!leftSubtree.isBST || !rightSubtree.isBST) return new Subtree(0, 0, 0, false);
        if ((leftSubtree.size == 0 || (leftSubtree.size > 0 && leftSubtree.largest < root.val)) &&
                (rightSubtree.size == 0 || (rightSubtree.size > 0 && rightSubtree.smallest > root.val))) {
            Subtree current = new Subtree(leftSubtree.size + rightSubtree.size + 1,
                    leftSubtree.size == 0 ? root.val : leftSubtree.smallest,
                    rightSubtree.size == 0 ? root.val : rightSubtree.largest, true);
            max = Math.max(max, current.size);
            return current;
        }
        return new Subtree(0, 0, 0, false);
    }

    private class Subtree {
        int size;
        int smallest;
        int largest;
        boolean isBST;

        Subtree(int size, int smallest, int largest, boolean isBST) {
            this.size = size;
            this.smallest = smallest;
            this.largest = largest;
            this.isBST = isBST;
        }
    }
}
