package com.leetcode;

import com.leetcode.model.ListNode;
import com.leetcode.service.AddTwoNumbers;
import com.leetcode.service.BiSolution;
import com.leetcode.service.Solution;
import com.leetcode.service.dp.IntegerBreak;
import com.leetcode.service.dp.NthUglyNumber;
import com.leetcode.service.dp.WiggleMaxLength;
import com.leetcode.service.dp.WordBreak;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        BiSolution<ListNode, ListNode, ListNode> solution = new AddTwoNumbers();
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        solution.solve(l1, l2);
    }
}
