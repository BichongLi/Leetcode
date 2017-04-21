package com.leetcode;

import com.leetcode.model.ListNode;
import com.leetcode.service.*;
import com.leetcode.service.dp.IntegerBreak;
import com.leetcode.service.dp.NthUglyNumber;
import com.leetcode.service.dp.WiggleMaxLength;
import com.leetcode.service.dp.WordBreak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution<List<String>, Integer> solution = new FindMinDifference();
        List<String> strings = new ArrayList<>();
        strings.add("23:59");
        strings.add("00:00");
        System.out.println(solution.solve(strings));
    }
}
