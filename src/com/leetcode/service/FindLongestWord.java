package com.leetcode.service;

import java.util.Collections;
import java.util.List;

/**
 * User: BichongLi
 * Date: 5/4/2017
 * Time: 8:38 PM
 */
public class FindLongestWord implements BiSolution<String, List<String>, String> {
    @Override
    public String solve(String s, List<String> d) {
        Collections.sort(d, (s1, s2) -> {
            if (s1.length() != s2.length()) {
                return s2.length() - s1.length();
            } else {
                for (int i = 0; i < s1.length(); i++) {
                    if (s1.charAt(i) < s2.charAt(i)) return -1;
                    else if (s1.charAt(i) > s2.charAt(i)) return 1;
                }
                return 0;
            }
        });
        int i, j;
        for (String ds : d) {
            j = 0;
            for (i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ds.charAt(j)) j++;
                if (j == ds.length()) return ds;
            }
        }
        return "";
    }
}
