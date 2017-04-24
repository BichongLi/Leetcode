package com.leetcode.service;

/**
 * User: BichongLi
 * Date: 4/24/2017
 * Time: 9:36 AM
 */
public class MaxProduct implements Solution<String[], Integer> {
    @Override
    public Integer solve(String[] words) {
        int count = words.length;
        int[] bitRep = new int[count];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                bitRep[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        int maxProduct = 0;
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if ((bitRep[i] & bitRep[j]) == 0) {
                    int product = words[i].length() * words[j].length();
                    maxProduct = maxProduct > product ? maxProduct : product;
                }
            }
        }
        return maxProduct;
    }
}
