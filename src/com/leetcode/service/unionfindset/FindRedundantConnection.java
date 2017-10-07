package com.leetcode.service.unionfindset;

import com.leetcode.service.Solution;

public class FindRedundantConnection implements Solution<int[][], int[]> {

    private int[] parent;

    @Override
    public int[] solve(int[][] edges) {
        if (edges == null || edges.length == 0) return new int[0];
        int[] res = new int[2];
        int n = edges.length;
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;
        for (int[] edge : edges) {
            int pStart = findParent(edge[0]);
            int pEnd = findParent(edge[1]);
            if (pStart == pEnd) return edge;
            parent[pEnd] = pStart;
        }
        return res;
    }

    private int findParent(int num) {
        if (parent[num] == num) return num;
        return findParent(parent[num]);
    }

}
