package com.leetcode;

import com.leetcode.service.*;
import com.leetcode.service.dp.CountSubstrings;
import com.leetcode.service.dp.FindPaths;
import com.leetcode.service.dp.GetMoneyAmount;
import com.leetcode.service.stack.RemoveKdigits;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        BiSolution solution = new RemoveKdigits();
        System.out.println(solution.solve("1432219", 3));
    }
}
