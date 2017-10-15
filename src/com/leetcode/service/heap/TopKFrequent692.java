package com.leetcode.service.heap;

import com.leetcode.service.BiSolution;

import java.util.*;

public class TopKFrequent692 implements BiSolution<String[], Integer, List<String>> {
    @Override
    public List<String> solve(String[] words, Integer k) {
        if (words == null || words.length == 0) return new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.putIfAbsent(word, 0);
            map.computeIfPresent(word, (s, count) -> count + 1);
        }
        PriorityQueue<Frequency> heap = new PriorityQueue<>();
        map.entrySet().stream().map(entry -> new Frequency(entry.getKey(), entry.getValue()))
                .forEach(frequency -> {
                    if (heap.size() < k) heap.offer(frequency);
                    else if (frequency.compareTo(heap.peek()) > 0) {
                        heap.poll();
                        heap.offer(frequency);
                    }
                });
        String[] res = new String[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = heap.poll().word;
        }
        return Arrays.asList(res);
    }

    private class Frequency implements Comparable<Frequency> {
        String word;
        int count;

        Frequency(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(Frequency that) {
            return this.count == that.count ? that.word.compareTo(this.word) : this.count - that.count;
        }
    }
}
