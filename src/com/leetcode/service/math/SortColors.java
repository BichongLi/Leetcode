package com.leetcode.service.math;

import com.leetcode.service.Solution;

/**
 * @author bichongli on 10/18/2017
 */
public class SortColors implements Solution<int[], Void> {
    @Override
    public Void solve(int[] nums) {
        if (nums == null || nums.length < 1) return null;
        int[] count = new int[3];
        for (int num : nums) count[num]++;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            while (count[i] == 0) i++;
            nums[j] = i;
            count[i]--;
        }
        return null;
    }
}
