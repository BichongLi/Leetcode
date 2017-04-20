package com.leetcode.service;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * User: BichongLi
 * Date: 4/20/2017
 * Time: 8:53 PM
 */
public class Minesweeper implements BiSolution<char[][], int[], char[][]> {

    private final int[][] dirs = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

    @Override
    public char[][] solve(char[][] board, int[] click) {
        Queue<Coordinate> queue = new ArrayDeque<>();
        queue.add(new Coordinate(click[0], click[1]));
        int maxRow = board.length;
        int maxCol = board[0].length;
        Set<Coordinate> tmpSet = new HashSet<>();
        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            if (board[current.x][current.y] == 'M') {
                board[current.x][current.y] = 'X';
                break;
            } else if (board[current.x][current.y] == 'E') {
                int mine = 0;
                tmpSet.clear();
                for (int i = 0; i < 8; i++) {
                    Coordinate c = new Coordinate(current.x + dirs[i][0], current.y + dirs[i][1]);
                    if (c.isLegal(maxRow, maxCol)) {
                        if (board[c.x][c.y] == 'M') mine++;
                        else if (board[c.x][c.y] == 'E') {
                            tmpSet.add(c);
                        }
                    }
                }
                if (mine == 0) {
                    board[current.x][current.y] = 'B';
                    queue.addAll(tmpSet);
                }
                else board[current.x][current.y] = (char)('0' + mine);
            }
        }
        return board;
    }

    private class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean isLegal(int maxRow, int maxCol) {
            return x >= 0 && x < maxRow && y >= 0 && y < maxCol;
        }
    }
}
