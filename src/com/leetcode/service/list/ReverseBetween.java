package com.leetcode.service.list;

import com.leetcode.model.ListNode;
import com.leetcode.service.TriSolution;

/**
 * User: BichongLi
 * Date: 8/4/2017
 * Time: 9:59 AM
 */
public class ReverseBetween implements TriSolution<ListNode, Integer, Integer, ListNode> {
    @Override
    public ListNode solve(ListNode head, Integer m, Integer n) {
        if (m == n) return head;
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode root = start;
        for (int i = 1; i < m; i++) start = start.next;
        ListNode pre = start, last = start.next;
        ListNode i = start.next, j = i.next, k = j.next;
        for (int p = m + 1; p <= n; p++) {
            j.next = i;
            i = j;
            j = k;
            if (k != null) k = k.next;
        }
        pre.next = i;
        last.next = j;
        return root.next;
    }
}
