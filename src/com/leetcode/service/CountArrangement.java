package com.leetcode.service;

/**
 * User: BichongLi
 * Date: 3/2/2017
 * Time: 4:02 PM
 */
public class CountArrangement implements Solution<Integer, Integer> {

    private int count;

    @Override
    public Integer solve(Integer N) {
        count = 0;
        search(1, N, new boolean[N + 1]);
        return count;
    }

    private void search(int pos, int N, boolean[] used) {
        if (pos > N) {
            count ++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!used[i] && (i % pos == 0 || pos % i == 0)) {
                used[i] = true;
                search(pos + 1, N, used);
                used[i] = false;
            }
        }
    }
}
