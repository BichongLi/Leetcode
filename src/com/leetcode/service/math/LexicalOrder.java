package com.leetcode.service.math;

import com.leetcode.service.Solution;

import java.util.ArrayList;
import java.util.List;

public class LexicalOrder implements Solution<Integer, List<Integer>> {
    @Override
    public List<Integer> solve(Integer n) {
        List<Integer> list = new ArrayList<>();
        if (n < 1) return list;
        int num = 1;
        for (int i = 1; i <= n; i++) {
            list.add(num);
            if (num * 10 <= n) num = num * 10;
            else if (num % 10 != 9 && num + 1 <= n) num++;
            else {
                num /= 10;
                while (num % 10 == 9) num /= 10;
                num++;
            }
        }
        return list;
    }
}
