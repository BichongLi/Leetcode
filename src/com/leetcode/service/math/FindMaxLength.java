package com.leetcode.service.math;

import com.leetcode.service.Solution;

import java.util.HashMap;
import java.util.Map;

public class FindMaxLength implements Solution<int[], Integer> {
    @Override
    public Integer solve(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) max = Math.max(max, i - map.get(sum));
            else map.put(sum, i);
        }
        return max;
    }
}
