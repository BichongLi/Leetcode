package com.leetcode;

import com.leetcode.service.BiSolution;
import com.leetcode.service.Solution;
import com.leetcode.service.TriSolution;
import com.leetcode.service.bfs.SurroundedRegions;
import com.leetcode.service.graph.CalcEquation;
import com.leetcode.service.graph.FindItinerary;
import com.leetcode.service.graph.FindMinHeightTrees;
import com.leetcode.service.search.FindOrder;
import com.leetcode.service.search.LongestIncreasingPath;
import com.leetcode.service.trie.PalindromePairs;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        BiSolution<Integer, int[][], List<Integer>> solution = new FindMinHeightTrees();
        solution.solve(6, new int[][]{{0,1},{0,2},{0,3},{3,4},{4,5}});
    }
}
