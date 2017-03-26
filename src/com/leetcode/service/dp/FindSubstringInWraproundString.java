package com.leetcode.service.dp;

import com.leetcode.service.Solution;

/**
 * User: BichongLi
 * Date: 3/24/2017
 * Time: 4:14 PM
 */
public class FindSubstringInWraproundString implements Solution<String, Integer> {
    @Override
    public Integer solve(String p) {
        if (p == null || p.length() == 0) return 0;
        int[] maxLength = new int[26];
        maxLength[p.charAt(0) - 'a'] = 1;
        int currentMax = 1;
        for (int i = 1; i < p.length(); i++) {
            if (charsTogether(p.charAt(i - 1), p.charAt(i))) {
                currentMax++;
            } else {
                currentMax = 1;
            }
            maxLength[p.charAt(i) - 'a'] = Math.max(maxLength[p.charAt(i) - 'a'], currentMax);
        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += maxLength[i];
        }
        return sum;
    }

    private boolean charsTogether(char c1, char c2) {
        return (c1 == 'z' && c2 == 'a' || c1 + 1 == c2);
    }
}
