package com.leetcode.service.graph;

import com.leetcode.service.TriSolution;

import java.util.*;

/**
 * @author bichongli on 9/13/2017
 */
public class CalcEquation implements TriSolution<String[][], double[], String[][], double[]> {
    @Override
    public double[] solve(String[][] equations, double[] values, String[][] queries) {
        if (equations == null || values == null || queries == null || queries.length == 0) return new double[0];
        double[] results = new double[queries.length];
        Map<String, List<Edge>> graph = initGraph(equations, values);
        Map<String, Double> cache = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            results[i] = findPath(graph, cache, queries[i][0], queries[i][1]);
        }
        return results;
    }

    private Map<String, List<Edge>> initGraph(String[][] equations, double[] values) {
        Map<String, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            addEdge(graph, equations[i][0], equations[i][1], values[i]);
            addEdge(graph, equations[i][1], equations[i][0], 1.0 / values[i]);
        }
        return graph;
    }

    private void addEdge(Map<String, List<Edge>> graph, String start, String end, double value) {
        List<Edge> edges;
        if (graph.containsKey(start)) edges = graph.get(start);
        else edges = new ArrayList<>();
        edges.add(new Edge(end, value));
        graph.put(start, edges);
    }

    private double findPath(Map<String, List<Edge>> graph, Map<String, Double> cache, String start, String end) {
        if (start.equals(end) && graph.containsKey(start)) return 1.0;
        if (start.equals(end) && !graph.containsKey(start)) return -1.0;
        Set<String> visited = new HashSet<>();
        String cacheKey = getCacheKey(start, end);
        if (cache.containsKey(cacheKey)) return cache.get(cacheKey);
        Queue<Edge> queue = new ArrayDeque<>();
        queue.add(new Edge(start, 1.0));
        while (!queue.isEmpty()) {
            Edge current = queue.poll();
            List<Edge> edges = graph.get(current.des);
            if (edges == null) continue;
            for (Edge edge : edges) {
                if (visited.contains(edge.des)) continue;
                double dis = current.value * edge.value;
                cache.put(getCacheKey(start, edge.des), dis);
                if (edge.des.equals(end)) return dis;
                queue.add(new Edge(edge.des, dis));
            }
            visited.add(current.des);
        }
        return -1.0;
    }

    private String getCacheKey(String start, String end) {
        return String.format("%1$s/%2$s", start, end);
    }

    private class Edge {
        String des;
        double value;

        Edge(String des, double value) {
            this.des = des;
            this.value = value;
        }
    }
}
