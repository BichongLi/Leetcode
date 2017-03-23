package com.leetcode;

import com.leetcode.service.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution<int[][], Integer> solution = new FindMinArrowShots();
        int[][] points = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
        System.out.println(solution.solve(points));
    }
}
