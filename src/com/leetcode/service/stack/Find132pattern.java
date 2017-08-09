package com.leetcode.service.stack;

import com.leetcode.service.Solution;

import java.util.Stack;

/**
 * User: BichongLi
 * Date: 8/9/2017
 * Time: 9:24 AM
 */
public class Find132pattern implements Solution<int[], Boolean> {
    @Override
    public Boolean solve(int[] nums) {
        int s3 = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < s3) return true;
            else {
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    s3 = stack.peek();
                    stack.pop();
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }
}
