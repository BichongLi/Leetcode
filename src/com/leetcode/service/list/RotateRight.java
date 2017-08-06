package com.leetcode.service.list;

import com.leetcode.model.ListNode;
import com.leetcode.service.BiSolution;

/**
 * User: BichongLi
 * Date: 8/6/2017
 * Time: 2:31 PM
 */
public class RotateRight implements BiSolution<ListNode, Integer, ListNode> {
    @Override
    public ListNode solve(ListNode head, Integer k) {
        if (head == null || head.next == null) return head;

        int length = 1;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            length ++;
        }
        ListNode tail = p;
        k = k % length;
        if (k == 0) return head;
        tail.next = head;
        p = head;
        for (int i = 0; i < length - k - 1; i++) {
            p = p.next;
        }
        head = p.next;
        p.next = null;
        return head;
    }
}
