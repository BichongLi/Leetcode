package com.leetcode.service;

import java.util.*;

/**
 * User: BichongLi
 * Date: 5/19/2017
 * Time: 9:19 AM
 */
public class KillProcess implements TriSolution<List<Integer>, List<Integer>, Integer, List<Integer>> {
    @Override
    public List<Integer> solve(List<Integer> pid, List<Integer> ppid, Integer kill) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        pid.forEach(p -> map.put(p, new HashSet<>()));
        for (int i = 0; i < ppid.size(); i++) {
            if (ppid.get(i) == 0) continue;
            map.get(ppid.get(i)).add(pid.get(i));
        }
        List<Integer> killed = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(kill);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            killed.add(current);
            queue.addAll(map.get(current));
        }
        return killed;
    }
}
