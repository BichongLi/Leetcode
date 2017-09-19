package com.leetcode.service.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.service.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bichongli on 9/19/2017
 */
public class RightSideView implements Solution<TreeNode, List<Integer>> {
    @Override
    public List<Integer> solve(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        boolean[] used = new boolean[1000];
        dfs(root, 0, used, res);
        return res;
    }

    private void dfs(TreeNode root, int depth, boolean[] used, List<Integer> res) {
        if (root == null) return;
        if (!used[depth]) {
            res.add(root.val);
            used[depth] = true;
        }
        dfs(root.right, depth + 1, used, res);
        dfs(root.left, depth + 1, used, res);
    }
}
