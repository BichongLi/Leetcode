package com.leetcode.service.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.service.Solution;

import java.util.*;

/**
 * @author bichongli on 9/22/2017
 */
public class ZigzagLevelOrder implements Solution<TreeNode, List<List<Integer>>> {
    @Override
    public List<List<Integer>> solve(TreeNode root) {
        if (root == null) return new ArrayList<>();
        return bfs(root);
    }

    private List<List<Integer>> bfs(TreeNode root) {
        Queue<TreeNode> pre = new ArrayDeque<>();
        Queue<TreeNode> cur = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.get(0).add(root.val);
        pre.add(root);
        boolean zigzag = true;
        while (!pre.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!pre.isEmpty()) {
                TreeNode node = pre.poll();
                if (zigzag) {
                    if (node.left != null) stack.push(node.left.val);
                    if (node.right != null) stack.push(node.right.val);
                } else {
                    if (node.left != null) list.add(node.left.val);
                    if (node.right != null) list.add(node.right.val);
                }
                if (node.left != null) cur.add(node.left);
                if (node.right != null) cur.add(node.right);
            }
            if (zigzag) {
                while (!stack.isEmpty())
                    list.add(stack.pop());
            }
            if (!list.isEmpty()) res.add(list);
            pre = cur;
            cur = new ArrayDeque<>();
            zigzag = !zigzag;
        }
        return res;
    }
}
