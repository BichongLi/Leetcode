package com.leetcode.service.dp;

/**
 * User: BichongLi
 * Date: 7/30/2017
 * Time: 1:07 PM
 */
public class FindPaths {

    private static final int MOD = 1000000007;
    private static final int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int solve(int m, int n, int N, int i, int j) {
        if (N == 0) return 0;
        int dp[][][] = new int[2][m][n];
        int cur = 1, pre = 0;
        for (int k = 1; k <= N - 1; k++) {
            cur = k % 2;
            pre = (k + 1) % 2;
            for (int p = 0; p < m; p++) {
                for (int q = 0; q < n; q++) {
                    dp[cur][p][q] = checkAround(dp[pre], p, q, m, n);
                }
            }
        }
        return checkAround(dp[cur], i, j, m, n);
    }

    private int checkAround(int dp[][], int x, int y, int m, int n) {
        int res = 0;
        int tx, ty;
        for (int k = 0; k < 4; k++) {
            tx = x + dirs[k][0];
            ty = y + dirs[k][1];
            if (tx < 0 || tx >= m || ty < 0 || ty >= n) {
                res = (res + 1) % MOD;
            } else {
                res = (res + dp[tx][ty]) % MOD;
            }
        }
        return res;
    }

}
