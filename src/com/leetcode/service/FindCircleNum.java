package com.leetcode.service;

/**
 * User: BichongLi
 * Date: 4/21/2017
 * Time: 9:40 AM
 */
public class FindCircleNum implements Solution<int[][], Integer> {

    private int[] parent = new int[205];
    private int[] rank = new int[205];
    private int count;

    @Override
    public Integer solve(int[][] M) {
        makeSet(M.length);
        for (int i = 0; i < M.length - 1; i++) {
            for (int j = i + 1; j < M.length; j++) {
                if (M[i][j] == 1) union(i, j);
            }
        }
        return count;
    }

    private void makeSet(int n) {
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    private void union(int x, int y) {
        int p1 = findRepresent(x);
        int p2 = findRepresent(y);
        if (p1 == p2) return;
        if (rank[p1] < rank[p2]) {
            parent[p1] = p2;
        } else if (rank[p1] == rank[p2]) {
            parent[p1] = p2;
            rank[p2]++;
        } else {
            parent[p2] = p1;
        }
        count--;
    }

    private int findRepresent(int n) {
        while (parent[n] != n) {
            parent[n] = parent[parent[n]];
            n = parent[n];
        }
        return n;
    }
}
