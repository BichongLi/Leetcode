package com.leetcode.service.list;

import com.leetcode.model.ListNode;
import com.leetcode.service.BiSolution;

import java.util.Stack;

/**
 * User: BichongLi
 * Date: 8/4/2017
 * Time: 9:17 PM
 */
public class AddTwoNumbers implements BiSolution<ListNode, ListNode, ListNode> {
    @Override
    public ListNode solve(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode tmp = l1;
        while (tmp != null) {
            s1.push(tmp.val);
            tmp = tmp.next;
        }
        tmp = l2;
        while (tmp != null) {
            s2.push(tmp.val);
            tmp = tmp.next;
        }
        int carry = 0;
        ListNode pre = null;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            ListNode current = new ListNode(s1.pop() + s2.pop() + carry);
            if (current.val >= 10) {
                carry = 1;
                current.val -= 10;
            } else carry = 0;
            current.next = pre;
            pre = current;
        }
        s1 = s1.isEmpty() ? s2 : s1;
        while (!s1.isEmpty()) {
            ListNode current = new ListNode(s1.pop() + carry);
            if (current.val >= 10) {
                carry = 1;
                current.val -= 10;
            } else carry = 0;
            current.next = pre;
            pre = current;
        }
        if (carry > 0) {
            ListNode head = new ListNode(carry);
            head.next = pre;
            pre = head;
        }
        return pre;
    }
}
