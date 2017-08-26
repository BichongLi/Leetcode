package com.leetcode.service.unionfindset;

import com.leetcode.service.Solution;

public class SurroundedRegions implements Solution<char[][], Void> {

    private static int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private int[] father;
    private int[] rank;

    private void makeSet(int n) {
        father = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
            rank[i] = 0;
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

    private boolean isConnected(int x, int y) {
        return find(x) == find(y);
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
    }

    @Override
    public Void solve(char[][] board) {
        if (board == null || board.length == 0) return null;
        int m = board.length;
        int n = board[0].length;
        int dummy = m * n, x, y;
        makeSet(dummy + 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n -1) &&
                        board[i][j] == 'O') union(i * n + j, dummy);
                else if (board[i][j] == 'O') {
                    for (int k = 0; k < 4; k++) {
                        x = i + dirs[k][0];
                        y = j + dirs[k][1];
                        if (board[x][y] == 'O') union(x * n + y, i * n + j);
                    }
                }
            }
        }
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O' && !isConnected(i * n + j, dummy)) {
                    board[i][j] = 'X';
                }
            }
        }
        return null;
    }
}
