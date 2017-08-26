package com.leetcode.service.unionfindset;

import com.leetcode.service.Solution;

/**
 * User: BichongLi
 * Date: 8/24/2017
 * Time: 9:41 AM
 */
public class NumIslands implements Solution<char[][], Integer> {

    private int[] father;
    private int[] rank;

    private int count;

    private void makeSet(char[][] grid) {
        count = 0;
        int m = grid.length;
        int n = grid[0].length;
        father = new int[m * n];
        rank = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    father[i * n + j] = i * n + j;
                    rank[i * n + j] = 0;
                }
            }
        }
    }

    private int find(int x) {
        int root, k, j;
        root = x;
        while (root != father[root]) root = father[root];
        k = x;
        while (k != root) {
            j = father[k];
            father[k] = root;
            k = j;
        }
        return root;
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return;
        if (rank[x] > rank[y]) father[y] = x;
        else {
            if (rank[x] == rank[y]) rank[y]++;
            father[x] = y;
        }
        count--;
    }

    @Override
    public Integer solve(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        makeSet(grid);
        int[][] dirs = new int[][]{{0, -1}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '1') continue;
                for (int k = 0; k < 2; k++) {
                    int x = i + dirs[k][0];
                    int y = j + dirs[k][1];
                    if (x >= 0 && y >= 0 && grid[x][y] == '1') {
                        union(i * n + j, x * n + y);
                    }
                }
            }
        }
        return count;
    }
}
