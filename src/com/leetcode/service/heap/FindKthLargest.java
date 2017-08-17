package com.leetcode.service.heap;

import com.leetcode.service.BiSolution;

import java.util.PriorityQueue;

/**
 * User: BichongLi
 * Date: 8/17/2017
 * Time: 8:26 PM
 */
public class FindKthLargest implements BiSolution<int[], Integer, Integer> {
    @Override
    public Integer solve(int[] nums, Integer k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (heap.size() < k) heap.add(nums[i]);
            else if (nums[i] >= heap.peek()) {
                heap.poll();
                heap.add(nums[i]);
            }
        }
        return heap.peek();
    }
}
