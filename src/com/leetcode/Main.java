package com.leetcode;

import com.leetcode.model.ListNode;
import com.leetcode.service.*;
import com.leetcode.service.dp.IntegerBreak;
import com.leetcode.service.dp.NthUglyNumber;
import com.leetcode.service.dp.WiggleMaxLength;
import com.leetcode.service.dp.WordBreak;
import com.leetcode.service.tree.FindMaximumXOR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution<int[], Integer> solution = new FindMaximumXOR();
        System.out.println(solution.solve(new int[] {3, 10, 5, 25, 2, 8}));
    }
}
