package com.leetcode.service.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.service.BiSolution;

/**
 * @author bichongli on 9/28/2017
 */
public class BuildTree implements BiSolution<int[], int[], TreeNode> {
    @Override
    public TreeNode solve(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int pl, int pr,
                           int[] inorder, int il, int ir) {
        if (pl > pr || il > ir) return null;
        if (pl == pr) return new TreeNode(preorder[pl]);
        TreeNode root = new TreeNode(preorder[pl]);
        int index = find(inorder, il, ir, root.val);
        root.left = build(preorder, pl + 1, pl + index - il,
                inorder, il, index - 1);
        root.right = build(preorder, pl + index - il + 1, pr,
                inorder, index + 1, ir);
        return root;
    }

    private int find(int[] order, int left, int right, int target) {
        for (int i = left; i <= right; i++) {
            if (order[i] == target) return i;
        }
        return 0;
    }
}
