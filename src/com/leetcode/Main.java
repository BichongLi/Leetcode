package com.leetcode;

import com.leetcode.service.Solution;
import com.leetcode.service.bfs.SurroundedRegions;
import com.leetcode.service.search.LongestIncreasingPath;
import com.leetcode.service.trie.PalindromePairs;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution<int[][], Integer> solution = new LongestIncreasingPath();
        System.out.println(solution.solve(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
    }
}
