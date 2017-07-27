package com.leetcode;

import com.leetcode.service.*;
import com.leetcode.service.dp.CountSubstrings;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution<String, Integer> solution = new CountSubstrings();
        System.out.println(solution.solve("abc"));
    }
}
