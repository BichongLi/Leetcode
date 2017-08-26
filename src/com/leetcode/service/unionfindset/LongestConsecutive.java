package com.leetcode.service.unionfindset;

import com.leetcode.service.Solution;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutive implements Solution<int[], Integer> {
    @Override
    public Integer solve(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int length, lower, upper;
        int max = 0;
        for (int num : nums) {
            if (map.containsKey(num)) continue;
            upper = map.getOrDefault(num + 1, 0);
            lower = map.getOrDefault(num - 1, 0);
            length = lower + upper + 1;
            if (upper == 0 && lower == 0) {
                map.put(num, 1);
            } else {
                map.put(num + upper, length);
                map.put(num - lower, length);
                map.put(num, length);
            }
            max = length > max ? length : max;
        }
        return max;
    }
}
