package com.leetcode.service.backtracking;

import com.leetcode.service.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bichongli on 8/23/2017
 */
public class RestoreIpAddresses implements Solution<String, List<String>> {
    @Override
    public List<String> solve(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12 || !valid(s)) return res;
        backtracking(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtracking(String s, int start, List<Integer> preState, List<String> res) {
        if (preState.size() == 4) {
            if (start != s.length()) return;
            StringBuilder builder = new StringBuilder(String.valueOf(preState.get(0)));
            for (int i = 1; i < preState.size(); i++) {
                builder.append(".").append(preState.get(i));
            }
            res.add(builder.toString());
        }

        if (start >= s.length()) return;

        int end = s.charAt(start) == '0' ? 2 : 4;
        for (int i = 1; i < end; i++) {
            if (start + i > s.length()) return;
            int num = atoi(s, start, start + i - 1);
            if (num < 0 || num > 255) continue;
            preState.add(num);
            backtracking(s, start + i, preState, res);
            preState.remove(preState.size() - 1);
        }
    }

    private boolean valid(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') return false;
        }
        return true;
    }

    private int atoi(String s, int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            res = res * 10 + (s.charAt(i) - '0');
        }
        return res;
    }
}
