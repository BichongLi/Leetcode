package com.leetcode.service.graph;

import com.leetcode.service.Solution;

import java.util.*;

public class FindItinerary implements Solution<String[][], List<String>> {

    private static final String START = "JFK";

    @Override
    public List<String> solve(String[][] tickets) {
        List<String> itinerary = new ArrayList<>();
        if (tickets == null || tickets.length == 0) return itinerary;
        Map<String, PriorityQueue<String>> graph = initGraph(tickets);
        dfs(START, graph, itinerary);
        return itinerary;
    }

    private void dfs(String location, Map<String, PriorityQueue<String>> graph, List<String> route) {
        while (graph.containsKey(location) && !graph.get(location).isEmpty())
            dfs(graph.get(location).poll(), graph, route);
        route.add(0, location);
    }

    private Map<String, PriorityQueue<String>> initGraph(String[][] tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (String[] ticket : tickets) {
            String start = ticket[0];
            String end = ticket[1];
            PriorityQueue<String> edges;
            if (graph.containsKey(start)) edges = graph.get(start);
            else edges = new PriorityQueue<>();
            edges.add(end);
            graph.put(start, edges);
        }
        return graph;
    }
}
