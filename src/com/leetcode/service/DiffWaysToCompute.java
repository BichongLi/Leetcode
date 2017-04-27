package com.leetcode.service;

import java.util.ArrayList;
import java.util.List;

/**
 * User: BichongLi
 * Date: 4/27/2017
 * Time: 9:53 AM
 */
public class DiffWaysToCompute implements Solution<String, List<Integer>> {
    @Override
    public List<Integer> solve(String input) {
        List<Integer> nums = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                num = num * 10 + input.charAt(i) - '0';
            } else {
                nums.add(num);
                num = 0;
                operators.add(String.valueOf(input.charAt(i)));
            }
        }
        nums.add(num);
        return dfs(nums, operators, 0, nums.size() - 1);
    }

    private List<Integer> dfs(List<Integer> nums, List<String> operators, int left, int right) {
        List<Integer> result = new ArrayList<>();
        if (left == right) {
            result.add(nums.get(left));
            return result;
        }
        for (int i = left; i < right; i++) {
            List<Integer> leftResults = dfs(nums, operators, left, i);
            List<Integer> rightResults = dfs(nums, operators, i + 1, right);
            for (Integer leftResult : leftResults) {
                for (Integer rightResult : rightResults) {
                    if (operators.get(i).equals("+")) result.add(leftResult + rightResult);
                    if (operators.get(i).equals("-")) result.add(leftResult - rightResult);
                    if (operators.get(i).equals("*")) result.add(leftResult * rightResult);
                }
            }
        }
        return result;
    }
}
