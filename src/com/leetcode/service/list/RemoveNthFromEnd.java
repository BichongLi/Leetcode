package com.leetcode.service.list;

import com.leetcode.model.ListNode;
import com.leetcode.service.BiSolution;

/**
 * User: BichongLi
 * Date: 8/2/2017
 * Time: 9:17 PM
 */
public class RemoveNthFromEnd implements BiSolution<ListNode, Integer, ListNode> {
    @Override
    public ListNode solve(ListNode head, Integer n) {
        ListNode start = new ListNode(0);
        ListNode fast = start, slow = start;
        start.next = head;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return start.next;
    }
}
