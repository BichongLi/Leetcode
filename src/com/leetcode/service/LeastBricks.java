package com.leetcode.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: BichongLi
 * Date: 5/2/2017
 * Time: 8:39 PM
 */
public class LeastBricks implements Solution<List<List<Integer>>, Integer> {
    @Override
    public Integer solve(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int width = wall.get(0).stream().reduce(0, (a, b) -> a + b);
        int max = Integer.MIN_VALUE;
        for (List<Integer> row : wall) {
            int sum = 0;
            for (Integer block : row) {
                sum += block;
                if (sum == width) break;
                if (map.containsKey(sum)) map.put(sum, map.get(sum) + 1);
                else map.put(sum, 1);
                max = max > map.get(sum) ? max : map.get(sum);
            }
        }
        if (max == Integer.MIN_VALUE) return wall.size();
        return wall.size() - max;
    }
}
