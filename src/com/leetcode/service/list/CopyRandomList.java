package com.leetcode.service.list;

import com.leetcode.model.RandomListNode;
import com.leetcode.service.Solution;

public class CopyRandomList implements Solution<RandomListNode, RandomListNode> {
    @Override
    public RandomListNode solve(RandomListNode head) {
        if (head == null) return null;
        RandomListNode current = head;
        while (current != null) {
            RandomListNode tmp = new RandomListNode(current.label);
            tmp.next = current.next;
            current.next = tmp;
            current = tmp.next;
        }
        current = head;
        while (current != null) {
            if (current.random != null) current.next.random = current.random.next;
            current = current.next.next;
        }
        RandomListNode newHead = head.next;
        current = head;
        while (current != null) {
            RandomListNode tmp = current.next.next;
            if (tmp == null) {
                current.next = null;
                current = null;
            } else {
                current.next.next = tmp.next;
                current.next = tmp;
                current = tmp;
            }
        }
        return newHead;
    }
}
