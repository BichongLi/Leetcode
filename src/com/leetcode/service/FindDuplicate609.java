package com.leetcode.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindDuplicate609 implements Solution<String[], List<List<String>>> {
    @Override
    public List<List<String>> solve(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) parsePath(path, map);
        return map.values().stream().filter(list -> list.size() > 1).collect(Collectors.toList());
    }

    private void parsePath(String path, Map<String, List<String>> map) {
        String[] parts = path.split(" ");
        String dir = parts[0];
        for (int i = 1; i < parts.length; i++) {
            int index = parts[i].indexOf('(');
            String fileName = parts[i].substring(0, index);
            String content = parts[i].substring(index + 1);
            map.putIfAbsent(content, new ArrayList<>());
            map.get(content).add(dir + "/" + fileName);
        }
    }
}
