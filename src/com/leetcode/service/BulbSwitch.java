package com.leetcode.service;

/**
 * User: BichongLi
 * Date: 4/28/2017
 * Time: 10:52 AM
 */
public class BulbSwitch implements Solution<Integer, Integer> {
    @Override
    public Integer solve(Integer n) {
        return (int) Math.sqrt(n);
    }
}
