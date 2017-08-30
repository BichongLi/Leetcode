package com.leetcode;

import com.leetcode.service.Solution;
import com.leetcode.service.bfs.SurroundedRegions;
import com.leetcode.service.trie.PalindromePairs;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution<String[], List<List<Integer>>> solution = new PalindromePairs();
        System.out.println(solution.solve(new String[] {"a", ""}));
    }
}
