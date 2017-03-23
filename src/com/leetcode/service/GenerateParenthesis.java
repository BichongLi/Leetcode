package com.leetcode.service;

import java.util.ArrayList;
import java.util.List;

/**
 * User: BichongLi
 * Date: 3/22/2017
 * Time: 8:10 PM
 */
public class GenerateParenthesis implements Solution<Integer, List<String>> {

    private List<String> parenthesis;

    @Override
    public List<String> solve(Integer n) {
        parenthesis = new ArrayList<>();
        search("", n, n, 0);
        return parenthesis;
    }

    private void search(String p, int left, int right, int unmatchedLeft) {
        if (left == 0 && right == 0) {
            parenthesis.add(p);
            return;
        }
        if (left != 0) {
            search(p + "(", left - 1, right, unmatchedLeft + 1);
        }
        if (right != 0) {
            if (unmatchedLeft != 0) {
                search(p + ")", left, right - 1, unmatchedLeft - 1);
            }
        }
    }
}