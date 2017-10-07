package com.leetcode.service.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.service.BiSolution;

public class BuildTree2 implements BiSolution<int[], int[], TreeNode> {
    @Override
    public TreeNode solve(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) return null;
        return dfs(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode dfs(int[] inorder, int[] postorder, int il, int ir,
                         int pl, int pr) {
        if (il == ir) return new TreeNode(inorder[il]);
        if (il > ir) return null;
        TreeNode root = new TreeNode(postorder[pr]);
        int index = findIndex(inorder, il, ir, postorder[pr]);
        int leftCount = index - il;
        root.left = dfs(inorder, postorder, il, index - 1, pl, pl + leftCount - 1);
        root.right = dfs(inorder, postorder, index + 1, ir, pl + leftCount, pr - 1);
        return root;
    }

    private int findIndex(int[] inorder, int il, int ir, int target) {
        for (int i = il; i <= ir; i++) {
            if (inorder[i] == target) return i;
        }
        return -1;
    }
}
