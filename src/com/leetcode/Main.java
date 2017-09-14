package com.leetcode;

import com.leetcode.service.BiSolution;
import com.leetcode.service.Solution;
import com.leetcode.service.TriSolution;
import com.leetcode.service.bfs.SurroundedRegions;
import com.leetcode.service.graph.CalcEquation;
import com.leetcode.service.search.FindOrder;
import com.leetcode.service.search.LongestIncreasingPath;
import com.leetcode.service.trie.PalindromePairs;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        TriSolution<String[][], double[], String[][], double[]> solution = new CalcEquation();
        double[] res = solution.solve(
                new String[][] {{"a","b"},{"b","c"}, {"bc", "cd"}},
                new double[] {1.5, 2.5, 5.0},
                new String[][] {{"a","c"},{"c","b"},{"bc","cd"},{"cd","bc"}}
        );
        for (double d : res) {
            System.out.println(d);
        }
    }
}
