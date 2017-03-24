package com.leetcode.service;

import java.util.HashMap;
import java.util.Map;

/**
 * User: BichongLi
 * Date: 3/22/2017
 * Time: 4:39 PM
 */
public class OriginalDigits implements Solution<String, String> {

    @Override
    public String solve(String s) {
        int[] count = new int[26];
        int[] result = new int[10];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        result[0] = check('z', "zero", count);
        result[8] = check('g', "eight", count);
        result[3] = check('h', "three", count);
        result[6] = check('x', "six", count);
        result[2] = check('w', "two", count);
        result[7] = check('s', "seven", count);
        result[4] = check('r', "four", count);
        result[5] = check('f', "five", count);
        result[9] = check('i', "nine", count);
        result[1] = check('o', "one", count);
        String output = "";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < result[i]; j++) {
                output += String.valueOf(i);
            }
        }
        return output;
    }

    private int check(char c, String num, int[] count) {
        if (count[c - 'a'] == 0) return 0;
        int minOccur = findMinAppear(num, count);
        for (int i = 0; i < num.length(); i++) {
            count[num.charAt(i) - 'a'] -= minOccur;
        }
        return minOccur;
    }

    private int findMinAppear(String num, int[] count) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < num.length(); i++) {
            min = min < count[num.charAt(i) - 'a'] ? min : count[num.charAt(i) - 'a'];
        }
        return min;
    }
}
