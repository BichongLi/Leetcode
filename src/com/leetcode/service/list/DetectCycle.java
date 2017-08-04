package com.leetcode.service.list;

import com.leetcode.model.ListNode;
import com.leetcode.service.Solution;

/**
 * User: BichongLi
 * Date: 8/3/2017
 * Time: 8:52 PM
 */
public class DetectCycle implements Solution<ListNode, ListNode> {
    @Override
    public ListNode solve(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if (fast.next == null || fast.next.next == null) return null;

        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
