package com.leetcode;

import com.leetcode.service.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        BiSolution<String, Integer, String> solution = new LicenseKeyFormatting();
        System.out.println(solution.solve("2-4A0r7-4k", 3));
    }
}
