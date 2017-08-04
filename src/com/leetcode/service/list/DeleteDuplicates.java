package com.leetcode.service.list;

import com.leetcode.model.ListNode;
import com.leetcode.service.Solution;

/**
 * User: BichongLi
 * Date: 8/4/2017
 * Time: 9:38 AM
 */
public class DeleteDuplicates implements Solution<ListNode, ListNode> {
    @Override
    public ListNode solve(ListNode head) {
        if (head == null) return null;
        ListNode p = new ListNode(0);
        ListNode root = p;
        p.next = head;
        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                ListNode q = p.next.next;
                while (q.next != null && p.next.val == q.next.val) q = q.next;
                p.next = q.next;
            } else {
                p = p.next;
            }
        }
        return root.next;
    }
}
