package com.leetcode.service.list;

import com.leetcode.model.ListNode;
import com.leetcode.model.TreeNode;
import com.leetcode.service.Solution;

/**
 * User: BichongLi
 * Date: 8/2/2017
 * Time: 9:04 PM
 */
public class SortedListToBST implements Solution<ListNode, TreeNode> {
    @Override
    public TreeNode solve(ListNode head) {
        if (head == null) return null;
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        return dfs(head, length);
    }

    private TreeNode dfs(ListNode head, int length) {
        if (length == 0) return null;
        if (length == 1) return new TreeNode(head.val);

        int pos = (length + 1) / 2;
        int i = 1;
        ListNode mid = head;
        while (i < pos) {
            mid = mid.next;
            i++;
        }
        TreeNode root = new TreeNode(mid.val);
        root.left = dfs(head, pos - 1);
        root.right = dfs(mid.next, length - pos);
        return root;
    }
}
