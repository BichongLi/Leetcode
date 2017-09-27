package com.leetcode.service.tree;

import com.leetcode.model.TreeLinkNode;
import com.leetcode.service.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bichongli on 9/27/2017
 */
public class Connect2 implements Solution<TreeLinkNode, Void> {

    @Override
    public Void solve(TreeLinkNode root) {
        if (root == null) return null;
        List<List<TreeLinkNode>> lists = new ArrayList<>();
        flatten(root, 1, lists);
        for (List<TreeLinkNode> list : lists) {
            int i, j;
            for (i = 0, j = 1; j < list.size(); i++, j++) {
                list.get(i).next = list.get(j);
            }
        }
        return null;
    }

    private void flatten(TreeLinkNode root, int depth, List<List<TreeLinkNode>> res) {
        if (root == null) return;
        if (depth > res.size()) res.add(new ArrayList<>());
        res.get(depth - 1).add(root);
        flatten(root.left, depth + 1, res);
        flatten(root.right, depth + 1, res);
    }
}
