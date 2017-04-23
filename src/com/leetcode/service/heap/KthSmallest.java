package com.leetcode.service.heap;

import com.leetcode.service.BiSolution;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * User: BichongLi
 * Date: 4/23/2017
 * Time: 3:02 PM
 */
public class KthSmallest implements BiSolution<int[][], Integer, Integer> {
    @Override
    public Integer solve(int[][] matrix, Integer k) {
        Queue<Integer> queue = new PriorityQueue<>(k, (p1, p2) -> p1 > p2 ? -1 : 1);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (queue.size() < k) {
                    queue.add(matrix[i][j]);
                } else {
                    if (matrix[i][j] < queue.peek()) {
                        queue.poll();
                        queue.add(matrix[i][j]);
                    } else {
                        break;
                    }
                }
            }
        }
        return queue.peek();
    }
}
