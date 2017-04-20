package com.leetcode.service;

import java.util.HashMap;

/**
 * User: BichongLi
 * Date: 4/4/2017
 * Time: 9:40 PM
 */
public class FourSumCount {

    public int solve(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                if (map.containsKey(sum)) map.put(sum, map.get(sum) + 1);
                else map.put(sum, 1);
            }
        }
        int result = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                if (map.containsKey(-sum)) result += map.get(-sum);
            }
        }
        return result;
    }

}
