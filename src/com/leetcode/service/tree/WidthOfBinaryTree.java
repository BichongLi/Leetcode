package com.leetcode.service.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.service.Solution;

import java.util.ArrayList;
import java.util.List;

public class WidthOfBinaryTree implements Solution<TreeNode, Integer> {
    @Override
    public Integer solve(TreeNode root) {
        if (root == null) return 0;
        int max = 1;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> rootLevel = new ArrayList<>();
        rootLevel.add(0);
        res.add(rootLevel);
        dfs(root, res, 1, 0);
        for (List<Integer> range : res) {
            int width;
            if (range.size() < 2) width = 1;
            else width = range.get(1) - range.get(0) + 1;
            max = Math.max(width, max);
        }
        return max;
    }

    private void dfs(TreeNode cur, List<List<Integer>> indexes, int depth, int pos) {
        if (cur == null || (cur.left == null && cur.right == null)) return;
        if (depth >= indexes.size()) indexes.add(new ArrayList<>());
        List<Integer> range = indexes.get(depth);
        if (cur.left != null) {
            int leftPos = pos == 0 ? 0 : 2 * pos;
            if (range.size() < 2) range.add(leftPos);
            else if (range.get(1) < leftPos) range.set(1, leftPos);
            dfs(cur.left, indexes, depth + 1, leftPos);
        }
        if (cur.right != null) {
            int rightPos = pos == 0 ? 1 : 2 * pos + 1;
            if (range.size() < 2) range.add(rightPos);
            else if (range.get(1) < rightPos) range.set(1, rightPos);
            dfs(cur.right, indexes, depth + 1, rightPos);
        }
    }
}
