package com.leetcode.service.tree;

import com.leetcode.model.TreeNode;

import java.util.*;

public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorderTraversal(root, sb);
        return sb.toString();
    }

    private void preorderTraversal(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("$/");
            return;
        }
        sb.append(root.val).append("/");
        preorderTraversal(root.left, sb);
        preorderTraversal(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() < 2) return null;
        Deque<String> list = new LinkedList<>();
        list.addAll(Arrays.asList(data.split("/")));
        return buildTree(list);
    }

    private TreeNode buildTree(Deque<String> list) {
        String val = list.remove();
        if (val.equals("$")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = buildTree(list);
        root.right = buildTree(list);
        return root;
    }

}
