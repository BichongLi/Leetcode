package com.leetcode.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: BichongLi
 * Date: 12/21/2016
 * Time: 3:46 PM
 */
public class QueueReconstruction implements Solution<int[][], int[][]> {

    @Override
    public int[][] solve(int[][] people) {
        List<People> list = new ArrayList<>();
        for (int[] aPeople : people) {
            list.add(new People(aPeople[0], aPeople[1]));
        }
        Collections.sort(list, (People p1, People p2) -> {
            if (p1.height == p2.height) return p1.before > p2.before ? 1 : -1;
            else return p1.height < p2.height ? 1 : -1;
        });

        People root = null;
        for (People p : list) {
            if (p.before == 0) {
                p.next = root;
                root = p;
            } else {
                int count = 1;
                People before = root;
                while (count < p.before) {
                    before = before.next;
                    count ++;
                }
                p.next = before.next;
                before.next = p;
            }
        }
        int[][] order = new int[people.length][2];
        int i = 0;
        while (root != null) {
            order[i][0] = root.height;
            order[i++][1] = root.before;
            root = root.next;
        }
        return order;
    }

    private class People {
        public int height;
        public int before;

        public People next;

        public People(int height, int before) {
            this.height = height;
            this.before = before;
            this.next = null;
        }
    }
}
