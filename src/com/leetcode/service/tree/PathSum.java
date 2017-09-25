package com.leetcode.service.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.service.BiSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bichongli on 9/25/2017
 */
public class PathSum implements BiSolution<TreeNode, Integer, List<List<Integer>>> {
    @Override
    public List<List<Integer>> solve(TreeNode root, Integer sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), root, sum, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, TreeNode current, int sum, int curSum) {
        if (current == null) return;
        if (current.left == null && current.right == null) {
            if (curSum + current.val == sum) {
                path.add(current.val);
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(current.val);
        dfs(res, path, current.left, sum, curSum + current.val);
        dfs(res, path, current.right, sum, curSum + current.val);
        path.remove(path.size() - 1);
    }
}
