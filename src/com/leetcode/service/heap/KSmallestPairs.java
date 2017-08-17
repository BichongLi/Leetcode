package com.leetcode.service.heap;

import com.leetcode.service.TriSolution;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * User: BichongLi
 * Date: 8/17/2017
 * Time: 9:17 PM
 */
public class KSmallestPairs implements TriSolution<int[], int[], Integer, List<int[]>> {
    @Override
    public List<int[]> solve(int[] nums1, int[] nums2, Integer k) {
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums2 == null ||
                nums1.length == 0 || nums2.length == 0) return res;
        int m = nums1.length;
        int n = nums2.length;
        PriorityQueue<Node> heap = new PriorityQueue<>(k);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Node node = new Node(nums1[i], nums2[j]);
                if (heap.size() < k) heap.add(node);
                else if (node.getSum() < heap.peek().getSum()) {
                    heap.poll();
                    heap.add(node);
                }
            }
        }

        while (!heap.isEmpty()) {
            res.add(heap.poll().getNums());
        }
        return res;
    }

    private class Node implements Comparable<Node> {
        int[] nums;

        Node(int a, int b) {
            this.nums = new int[2];
            this.nums[0] = a;
            this.nums[1] = b;
        }

        int[] getNums() {
            return nums;
        }

        int getSum() {
            return nums[0] + nums[1];
        }

        @Override
        public int compareTo(Node that) {
            return (that.nums[0] + that.nums[1]) - (this.nums[0] + this.nums[1]);
        }
    }
}
