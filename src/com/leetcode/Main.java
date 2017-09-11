package com.leetcode;

import com.leetcode.service.BiSolution;
import com.leetcode.service.Solution;
import com.leetcode.service.bfs.SurroundedRegions;
import com.leetcode.service.search.FindOrder;
import com.leetcode.service.search.LongestIncreasingPath;
import com.leetcode.service.trie.PalindromePairs;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        BiSolution<Integer, int[][], int[]> solution = new FindOrder();
        System.out.println(solution.solve(2, new int[][]{{0, 1}, {1, 0}}));
    }
}
