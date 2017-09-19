package com.leetcode.service.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.service.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bichongli on 9/19/2017
 */
public class LevelOrder implements Solution<TreeNode, List<List<Integer>>> {
    @Override
    public List<List<Integer>> solve(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(res, root, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, TreeNode root, int depth) {
        if (root == null) return;
        if (res.size() <= depth) res.add(new ArrayList<>());
        res.get(depth).add(root.val);
        dfs(res, root.left, depth + 1);
        dfs(res, root.right, depth + 1);
    }
}
