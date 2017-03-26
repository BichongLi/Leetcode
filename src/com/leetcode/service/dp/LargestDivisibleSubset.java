package com.leetcode.service.dp;

import com.leetcode.service.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: BichongLi
 * Date: 3/25/2017
 * Time: 3:31 PM
 */
public class LargestDivisibleSubset implements Solution<int[], List<Integer>> {

    private List<Integer>[] sets;

    @Override
    public List<Integer> solve(int[] nums) {
        if (nums == null || nums.length < 1) return new ArrayList<>();
        sets = new List[nums.length];
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        dp[0] = 1;
        sets[0] = new ArrayList<>();
        sets[0].add(nums[0]);
        int maxLength = 1;
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            int index = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        index = j;
                    }
                }
            }
            sets[i] = new ArrayList<>();
            if (index != -1) {
                sets[i].addAll(sets[index]);
                sets[i].add(nums[i]);
                if (dp[i] > maxLength) {
                    maxLength = dp[i];
                    maxIndex = i;
                }
            } else {
                sets[i].add(nums[i]);
            }
        }
        return sets[maxIndex];
    }
}
