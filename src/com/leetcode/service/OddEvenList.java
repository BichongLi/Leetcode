package com.leetcode.service;

import com.leetcode.model.ListNode;

/**
 * User: BichongLi
 * Date: 3/23/2017
 * Time: 11:46 AM
 */
public class OddEvenList implements Solution<ListNode, ListNode> {
    @Override
    public ListNode solve(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode firstEven = head.next;
        ListNode lastEven = head.next;
        ListNode lastOdd = head;
        ListNode toFlip = head.next.next;
        while (lastEven != null && toFlip != null) {
            ListNode tmp = toFlip.next;
            toFlip.next = firstEven;
            lastEven.next = tmp;
            lastOdd.next = toFlip;
            lastOdd = toFlip;
            lastEven = tmp;
            toFlip = tmp == null ? null : tmp.next;
        }
        return head;
    }
}
