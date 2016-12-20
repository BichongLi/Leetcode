package com.leetcode.service;

/**
 * User: BichongLi
 * Date: 12/19/2016
 * Time: 9:01 PM
 */
public class CountBattleships implements Solution<char[][], Integer> {
    @Override
    public Integer solve(char[][] board) {
        int count = 0;
        boolean[][] flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (findBattle(board, flag, i, j)) count++;
            }
        }
        return count;
    }

    private boolean findBattle(char[][] board, boolean[][] flag, int i, int j) {
        if (board[i][j] != 'X' || flag[i][j]) return false;
        flag[i][j] = true;
        for (int x = i + 1; x < board.length; x++) {
            if (board[x][j] == 'X') flag[x][j] = true;
            else break;
        }
        for (int y = j + 1; y < board[0].length; y++) {
            if (board[i][y] == 'X') flag[i][y] = true;
            else break;
        }
        return true;
    }
}
