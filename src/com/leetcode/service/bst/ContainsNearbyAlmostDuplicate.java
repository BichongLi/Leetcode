package com.leetcode.service.bst;

import com.leetcode.service.TriSolution;

import java.util.Map;
import java.util.TreeMap;

/**
 * User: BichongLi
 * Date: 8/16/2017
 * Time: 9:35 PM
 */
public class ContainsNearbyAlmostDuplicate implements TriSolution<int[], Integer, Integer, Boolean> {
    @Override
    public Boolean solve(int[] nums, Integer k, Integer t) {
        if (nums == null || nums.length <= 1) return false;
        TreeMap<Double, Integer> map = new TreeMap<>();
        map.put((double) nums[0], 0);
        double floor, ceil;
        for (int j = 1; j < nums.length; j++) {
            ceil = ((double) nums[j]) - t;
            floor = ((double) nums[j]) + t;
            Map.Entry<Double, Integer> floorId = map.floorEntry(floor);
            Map.Entry<Double, Integer> ceilId = map.ceilingEntry(ceil);
            if ((floorId != null && j - floorId.getValue() <= k && floorId.getKey() >= ceil) ||
                    (ceilId != null && j - ceilId.getValue() <= k && ceilId.getKey() <= floor)) return true;
            map.put((double) nums[j], j);
        }
        return false;
    }
}
