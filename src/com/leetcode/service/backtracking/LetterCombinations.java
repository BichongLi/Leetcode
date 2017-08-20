package com.leetcode.service.backtracking;

import com.leetcode.service.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: BichongLi
 * Date: 8/20/2017
 * Time: 11:31 AM
 */
public class LetterCombinations implements Solution<String, List<String>> {

    private static Map<Character, String> phone = new HashMap<>();

    static {
        phone.put('2', "abc");
        phone.put('3', "def");
        phone.put('4', "ghi");
        phone.put('5', "jkl");
        phone.put('6', "mno");
        phone.put('7', "pqrs");
        phone.put('8', "tuv");
        phone.put('9', "wxyz");
    }

    @Override
    public List<String> solve(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() ==0 ||
                digits.contains("1") || digits.contains("0")) return res;
        backtracking(digits, 0, new StringBuilder(), res);
        return res;
    }

    private void backtracking(String digits, int idx,
                              StringBuilder preState, List<String> res) {
        if (idx >= digits.length()) {
            res.add(preState.toString());
            return;
        }
        String letters = phone.get(digits.charAt(idx));
        for (int i = 0; i < letters.length(); i++) {
            preState.append(letters.charAt(i));
            backtracking(digits, idx + 1, preState, res);
            preState.deleteCharAt(preState.length() - 1);
        }
    }
}
