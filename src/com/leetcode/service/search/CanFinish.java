package com.leetcode.service.search;

import com.leetcode.service.BiSolution;

public class CanFinish implements BiSolution<Integer, int[][], Boolean> {

    private int count;

    @Override
    public Boolean solve(Integer numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length < 2) return true;
        boolean[][] g = new boolean[numCourses][numCourses];
        for (int[] prerequisite : prerequisites) {
            g[prerequisite[1]][prerequisite[0]] = true;
        }
        int[] flag = new int[numCourses];
        count = numCourses - 1;
        while (count >= 0) {
            for (int i = 0; i < numCourses; i++) {
                if (flag[i] == 0 && !dfs(g, flag, i)) return false;
            }
        }
        return true;
    }

    private boolean dfs(boolean[][] g, int[] flag, int node) {
        if (flag[node] == 2) return true;
        if (flag[node] == 1) return false;
        flag[node] = 1;
        for (int i = 0; i < g.length; i++) {
            if (i != node && g[node][i] && !dfs(g, flag, i)) return false;
        }
        flag[node] = 2;
        count--;
        return true;
    }
}
