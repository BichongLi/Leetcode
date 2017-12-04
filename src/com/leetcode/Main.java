package com.leetcode;

import com.leetcode.service.*;
import com.leetcode.service.binarysearch.Search33;
import com.leetcode.service.heap.GetSkyline;
import com.leetcode.service.math.MaximumSwap;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution<int[][], List<int[]>> solution = new GetSkyline();
        solution.solve(new int[][] {{2,4,7},{2,4,5},{2,4,6}});
    }
}
