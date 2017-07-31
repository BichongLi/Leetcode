package com.leetcode;

import com.leetcode.service.*;
import com.leetcode.service.dp.CountSubstrings;
import com.leetcode.service.dp.FindPaths;
import com.leetcode.service.dp.GetMoneyAmount;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FindPaths solution = new FindPaths();
        System.out.println(solution.solve(10, 10, 0, 5, 5));
    }
}
