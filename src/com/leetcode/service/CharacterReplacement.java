package com.leetcode.service;

/**
 * User: BichongLi
 * Date: 5/3/2017
 * Time: 8:57 PM
 */
public class CharacterReplacement implements BiSolution<String, Integer, Integer> {
    @Override
    public Integer solve(String s, Integer k) {
        int[] count = new int[26];
        int start = 0;
        int maxCount = 0;
        int end = 0;
        for (; end < s.length(); end++) {
            count[s.charAt(end) - 'A']++;
            if (count[s.charAt(end) - 'A'] > maxCount) maxCount = count[s.charAt(end) - 'A'];
            while (end - start + 1 > k + maxCount) {
                count[s.charAt(start++) - 'A']--;
            }
        }
        return end - start;
    }
}
