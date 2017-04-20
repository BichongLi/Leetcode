package com.leetcode.service;

import java.util.Arrays;
import java.util.Stack;

/**
 * User: BichongLi
 * Date: 4/20/2017
 * Time: 9:35 PM
 */
public class NextGreaterElements implements Solution<int[], int[]> {
    @Override
    public int[] solve(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(res, -1);
        int length = nums.length;
        for (int i = 0; i < 2 * length; i++) {
            int index = i % length;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
                res[stack.pop()] = nums[index];
            }
            if (i < length) stack.push(index);
        }
        return res;
    }
}
