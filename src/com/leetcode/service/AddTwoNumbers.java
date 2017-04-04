package com.leetcode.service;

import com.leetcode.model.ListNode;

import java.util.Stack;

/**
 * User: BichongLi
 * Date: 4/4/2017
 * Time: 9:06 PM
 */
public class AddTwoNumbers implements BiSolution<ListNode, ListNode, ListNode> {
    @Override
    public ListNode solve(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = loadStack(l1);
        Stack<Integer> s2 = loadStack(l2);
        ListNode root = null;
        int carryOn = 0;
        int sum;
        while (!s1.isEmpty() || !s2.isEmpty() || carryOn != 0) {
            sum = carryOn;
            carryOn = 0;
            if (!s1.isEmpty()) sum += s1.pop();
            if (!s2.isEmpty()) sum += s2.pop();
            if (sum > 9) {
                carryOn = 1;
                sum -= 10;
            }
            if (root == null) root = new ListNode(sum);
            else {
                ListNode tmp = new ListNode(sum);
                tmp.next = root;
                root = tmp;
            }
        }
        return root;
    }

    private Stack<Integer> loadStack(ListNode root) {
        Stack<Integer> stack = new Stack<>();
        while (root != null) {
            stack.push(root.val);
            root = root.next;
        }
        return stack;
    }
}
