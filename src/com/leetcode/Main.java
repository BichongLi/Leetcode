package com.leetcode;

import com.leetcode.model.ListNode;
import com.leetcode.service.*;
import com.leetcode.service.dp.IntegerBreak;
import com.leetcode.service.dp.NthUglyNumber;
import com.leetcode.service.dp.WiggleMaxLength;
import com.leetcode.service.dp.WordBreak;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution<int[], int[]> solution = new NextGreaterElements();
        int[] res = solution.solve(new int[]{1, 2, 1});
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
