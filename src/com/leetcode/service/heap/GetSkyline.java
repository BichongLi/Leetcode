package com.leetcode.service.heap;

import com.leetcode.service.Solution;

import java.util.*;

public class GetSkyline implements Solution<int[][], List<int[]>> {
    @Override
    public List<int[]> solve(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0) return res;
        List<Node> nodes = new ArrayList<>();
        for (int[] building : buildings) {
            nodes.add(new Node(building[0], building[2], true));
            nodes.add(new Node(building[1], building[2], false));
        }
        nodes.sort((n1, n2) -> {
            if (n1.x != n2.x) return n1.x - n2.x;
            if (n1.isLeft && n2.isLeft) return n2.y - n1.y;
            if (!n1.isLeft && !n2.isLeft) return n1.y - n2.y;
            return n1.isLeft ? -1 : 1;
        });
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        heap.add(0);
        int prev = 0;
        for (Node node : nodes) {
            if (node.isLeft) heap.offer(node.y);
            else heap.remove(node.y);
            int cur = heap.peek();
            if (cur != prev) res.add(new int[] {node.x, cur});
            prev = cur;
        }
        return res;
    }

    private class Node {
        int x;
        int y;
        boolean isLeft;

        Node(int x, int y, boolean isLeft) {
            this.x = x;
            this.y = y;
            this.isLeft = isLeft;
        }
    }
}
