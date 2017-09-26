package com.leetcode.service.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.service.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bichongli on 9/26/2017
 */
public class FindDuplicateSubtrees implements Solution<TreeNode, List<TreeNode>> {
    @Override
    public List<TreeNode> solve(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) return res;
        dfs(res, new HashMap<>(), root);
        return res;
    }

    private String dfs(List<TreeNode> res, Map<String, Integer> map, TreeNode current) {
        if (current == null) return "#";
        String key = String.format("%1$d/%2$s/%3$s", current.val, dfs(res, map, current.left), dfs(res, map, current.right));
        Integer count = map.get(key);
        if (count == null) count = 0;
        if (count == 1) res.add(current);
        map.put(key, count + 1);
        return key;
    }
}
