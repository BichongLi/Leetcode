package com.leetcode.service;

import java.util.Arrays;

/**
 * User: BichongLi
 * Date: 3/3/2017
 * Time: 7:49 PM
 */
public class MinMoves2 implements Solution<int[], Integer> {
    @Override
    public Integer solve(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        Arrays.sort(nums);
        int target = nums[0];
        int N1 = 0;
        int N2 = 1;
        for (int i = 1; i < nums.length && nums[i] == target; i++) {
            N2++;
        }
        int N3 = nums.length - N2;
        int minMove = 0;
        for (int i = 1; i < nums.length; i++) {
            minMove += nums[i] - target;
        }
        int minBig = 0;
        if (N3 > 0) minBig = nums[N2];
        while (true) {
            if (N1 + N2 < N3) {
                minMove += (N1 + N2 - N3) * (minBig - target);
                target = minBig;
                N1 += N2;
                N2 = 0;
                int i;
                for (i = N1; i < nums.length && nums[i] == target; i++) {
                    N2++;
                }
                N3 = nums.length - N2 - N1;
                if (N3 > 0) {
                    minBig = nums[i];
                }
            } else {
                break;
            }
        }
        return minMove;
    }
}
