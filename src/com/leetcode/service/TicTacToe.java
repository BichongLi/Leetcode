package com.leetcode.service;

public class TicTacToe {

    private int n;
    private int[][] rows;
    private int[][] cols;
    private int dg[];
    private int antiDg[];

    public TicTacToe(int n) {
        this.n = n;
        rows = new int[3][n];
        cols = new int[3][n];
        dg = new int[3];
        antiDg = new int[3];
    }

    public int move(int row, int col, int player) {
        int other = player ^ 3;
        if (row == col && dg[other] == 0) {
            dg[player]++;
            if (dg[player] == n) return player;
        }
        if (row + col == n - 1 && antiDg[other] == 0) {
            antiDg[player]++;
            if (antiDg[player] == n) return player;
        }
        if (rows[other][row] == 0) {
            rows[player][row]++;
            if (rows[player][row] == n) return player;
        }
        if (cols[other][col] == 0) {
            cols[player][col]++;
            if (cols[player][col] == n) return player;
        }
        return 0;
    }
}
