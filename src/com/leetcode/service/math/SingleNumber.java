package com.leetcode.service.math;

import com.leetcode.service.Solution;

/**
 * @author bichongli on 10/12/2017
 */
public class SingleNumber implements Solution<int[], Integer> {
    @Override
    public Integer solve(int[] nums) {
        int ones = 0, twos = 0, threes;
        for (int num : nums) {
            twos |= (ones & num);
            ones ^= num;
            threes = ones & twos;
            ones &= (~threes);
            twos &= (~threes);
        }
        return ones;
    }
}
