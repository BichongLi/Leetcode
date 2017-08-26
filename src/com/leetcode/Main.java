package com.leetcode;

import com.leetcode.service.Solution;
import com.leetcode.service.bfs.SurroundedRegions;

public class Main {

    public static void main(String[] args) {
        Solution<char[][], Void> solution = new SurroundedRegions();
        System.out.println(solution.solve(new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}}));
    }
}
