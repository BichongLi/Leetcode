package com.leetcode.service.search;

import com.leetcode.service.BiSolution;

public class FindOrder implements BiSolution<Integer, int[][], int[]> {

    private int count;
    private int[] res;
    private boolean hasCycle;

    @Override
    public int[] solve(Integer numCourses, int[][] prerequisites) {
        res = new int[numCourses];
        if (numCourses == 0 || prerequisites == null) return res;
        boolean[][] g = new boolean[numCourses][numCourses];
        for (int[] prerequisite : prerequisites) {
            g[prerequisite[1]][prerequisite[0]] = true;
        }
        int[] flag = new int[numCourses];
        count = numCourses - 1;
        hasCycle = false;
        while (count >= 0) {
            for (int i = 0; i < numCourses; i++) {
                if (flag[i] == 0) dfs(g, flag, i);
                if (hasCycle) return new int[0];
            }
        }
        return res;
    }

    private void dfs(boolean[][] g, int[] flag, int node) {
        if (flag[node] == 2 || hasCycle) return;
        if (flag[node] == 1) {
            hasCycle = true;
            return;
        }
        flag[node] = 1;
        for (int i = 0; i < g.length; i++) {
            if (i != node && g[node][i]) dfs(g, flag, i);
            if (hasCycle) return;
        }
        flag[node] = 2;
        res[count--] = node;
    }
}
