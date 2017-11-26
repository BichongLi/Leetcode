package com.leetcode.service.list;

import com.leetcode.model.ListNode;
import com.leetcode.service.Solution;

public class HasCycle implements Solution<ListNode, Boolean> {
    @Override
    public Boolean solve(ListNode head) {
        if (head == null) return false;
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            if (p2.next != null) p2 = p2.next.next;
            else break;
            if (p1 != null && p2 != null && p1 == p2) return true;
        }
        return false;
    }
}
