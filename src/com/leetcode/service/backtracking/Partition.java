package com.leetcode.service.backtracking;

import com.leetcode.service.Solution;

import java.util.ArrayList;
import java.util.List;

public class Partition implements Solution<String, List<List<String>>> {
    @Override
    public List<List<String>> solve(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        if (isPalindrome(s)) {
            List<String> itself = new ArrayList<>();
            itself.add(s);
            res.add(itself);
        }
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            if (isPalindrome(left)) {
                List<List<String>> partitions = solve(s.substring(i, s.length()));
                partitions.forEach(p -> p.add(0, left));
                res.addAll(partitions);
            }
        }
        return res;
    }

    private boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.length() == 1) return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) break;
            i++;
            j--;
        }
        return i >= j;
    }
}
