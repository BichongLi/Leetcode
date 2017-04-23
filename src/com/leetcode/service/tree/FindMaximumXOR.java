package com.leetcode.service.tree;

import com.leetcode.service.Solution;

/**
 * User: BichongLi
 * Date: 4/23/2017
 * Time: 2:10 PM
 */
public class FindMaximumXOR implements Solution<int[], Integer> {

    private int maxXOR = 0;

    @Override
    public Integer solve(int[] nums) {
        Node root = new Node(-1);
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            max = max > nums[i] ? max : nums[i];
        }
        int mask = createMask(max);
        for (int i = 0; i < nums.length; i++) {
            addToDict(nums[i], root, mask);
        }
        while (root.children[0] == null || root.children[1] == null) {
            if (root.children[0] != null) {
                root = root.children[0];
            } else if (root.children[1] != null) {
                root = root.children[1];
            } else {
                return 0;
            }
        }
        dfs(root.children[0], root.children[1], 0);
        return maxXOR;
    }

    private int createMask(int n) {
        n |= (n >>> 1);
        n |= (n >>> 2);
        n |= (n >>> 4);
        n |= (n >>> 8);
        n |= (n >>> 16);
        return n ^ (n >>> 1);
    }

    private void addToDict(int num, Node root, int mask) {
        Node cur = root;
        while (mask > 0) {
            if ((mask & num) != 0) {
                if (cur.children[1] == null) cur.children[1] = new Node(1);
                cur = cur.children[1];
            } else {
                if (cur.children[0] == null) cur.children[0] = new Node(0);
                cur = cur.children[0];
            }
            mask = mask >>> 1;
        }
    }

    private void dfs(Node left, Node right, int pre) {
        int cur;
        if (left.val != right.val) {
            cur = (pre << 1) + 1;
        } else {
            cur = (pre << 1);
        }
        if (left.children[0] == null && left.children[1] == null
                && right.children[0] == null && right.children[1] == null) {
            maxXOR = maxXOR > cur ? maxXOR : cur;
            return;
        }
        boolean skip = false;
        if (left.children[0] != null && right.children[1] != null) {
            dfs(left.children[0], right.children[1], cur);
            skip = true;
        }
        if (left.children[1] != null && right.children[0] != null) {
            dfs(left.children[1], right.children[0], cur);
            skip = true;
        }
        if (!skip) {
            if (left.children[0] != null && right.children[0] != null) {
                dfs(left.children[0], right.children[0], cur);
            }
            if (left.children[1] != null && right.children[1] != null) {
                dfs(left.children[1], right.children[1], cur);
            }
        }
    }

    private class Node {
        int val;
        Node[] children = new Node[2];

        Node(int val) {
            this.val = val;
            children[0] = null;
            children[1] = null;
        }
    }
}
