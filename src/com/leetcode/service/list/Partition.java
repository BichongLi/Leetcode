package com.leetcode.service.list;

import com.leetcode.model.ListNode;
import com.leetcode.service.BiSolution;

/**
 * User: BichongLi
 * Date: 8/3/2017
 * Time: 9:38 AM
 */
public class Partition implements BiSolution<ListNode, Integer, ListNode> {
    @Override
    public ListNode solve(ListNode head, Integer x) {
        ListNode s1 = new ListNode(0);
        ListNode s2 = new ListNode(0);
        ListNode p1 = s1;
        ListNode p2 = s2;
        while (head != null) {
            if (head.val < x) {
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        p2.next = null;
        p1.next = s2.next;
        return s1.next;
    }
}
