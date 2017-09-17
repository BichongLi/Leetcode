package com.leetcode.service.graph;

import com.leetcode.service.BiSolution;

import java.util.ArrayList;
import java.util.List;

public class FindMinHeightTrees implements BiSolution<Integer, int[][], List<Integer>> {
    @Override
    public List<Integer> solve(Integer n, int[][] edges) {
        if (edges == null || edges.length == 0) {
            List<Integer> res = new ArrayList<>();
            if (n == 1) res.add(0);
            return res;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            List<Integer> adj = graph.get(edge[0]);
            List<Integer> adj1 = graph.get(edge[1]);
            adj.add(edge[1]);
            adj1.add(edge[0]);
            graph.set(edge[0], adj);
            graph.set(edge[1], adj1);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i).size() == 1) leaves.add(i);
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (Integer leaf : leaves) {
                int next = graph.get(leaf).iterator().next();
                graph.get(next).remove(leaf);
                if (graph.get(next).size() == 1) newLeaves.add(next);
            }
            leaves = newLeaves;
        }

        return leaves;
    }
}
