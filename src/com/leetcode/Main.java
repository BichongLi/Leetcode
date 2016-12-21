package com.leetcode;

import com.leetcode.service.*;

public class Main {

    public static void main(String[] args) {
        Solution<int[][], int[][]> solution = new QueueReconstruction();
        int[][] result = solution.solve(
                new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}}
        );
        for (int i = 0 ; i < result.length; i++) {
            System.out.println(String.format("%1$d, %2$d", result[i][0], result[i][1]));
        }
    }
}
