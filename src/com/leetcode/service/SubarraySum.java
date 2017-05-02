package com.leetcode.service;

import java.util.HashMap;
import java.util.Map;

/**
 * User: BichongLi
 * Date: 5/2/2017
 * Time: 8:35 PM
 */
public class SubarraySum implements BiSolution<int[], Integer, Integer> {
    @Override
    public Integer solve(int[] nums, Integer k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int tmp = sum - k;
            if (map.containsKey(tmp)) count += map.get(tmp);
            if (map.containsKey(sum)) map.put(sum, map.get(sum) + 1);
            else map.put(sum, 1);
        }
        return count;
    }
}
