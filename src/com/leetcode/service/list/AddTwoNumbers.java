package com.leetcode.service.list;

import com.leetcode.model.ListNode;
import com.leetcode.service.BiSolution;

/**
 * User: BichongLi
 * Date: 8/4/2017
 * Time: 9:17 PM
 */
public class AddTwoNumbers implements BiSolution<ListNode, ListNode, ListNode> {
    @Override
    public ListNode solve(ListNode l1, ListNode l2) {
        ListNode i = l1, j = l2;
        int carry = 0;
        ListNode pre = new ListNode(0);
        pre.next = i;
        while (i != null || j != null) {
            if (i == null) {
                i = new ListNode(0);
                pre.next = i;
            }
            i.val = j == null ? i.val + carry : i.val + j.val + carry;
            if (i.val >= 10) {
                carry = 1;
                i.val -= 10;
            } else {
                carry = 0;
            }
            i = i.next;
            if (j != null) j = j.next;
            pre = pre.next;
        }
        if (carry > 0) pre.next = new ListNode(carry);
        return l1;
    }
}
