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
        int[][] dirs = new int[][] {{0, -1}, {-1, 0}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue;
                boolean flag = false;
                for (int k = 0; k < 2; k++) {
                    int tx = i + dirs[k][0];
                    int ty = j + dirs[k][1];
                    if (tx >= 0 && ty >= 0 && board[tx][ty] == 'X') {
                        flag = true;
                        break;
                    }
                }
                if (!flag) count++;
            }
        }
        return count;
    }
}
