package com.leetcode.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * User: BichongLi
 * Date: 12/21/2016
 * Time: 11:01 AM
 */
public class SortCharactersByFrequency implements Solution<String, String> {
    @Override
    public String solve(String s) {
        return solveWithHeap(s);
    }

    private String solveWithHeap(String s) {
        CharacterFrequency[] heap = new CharacterFrequency[s.length()];
        int currentIndex = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                heap[map.get(c)].count++;
            } else {
                map.put(c, currentIndex);
                heap[currentIndex++] = new CharacterFrequency(c, 1);
            }
        }
        heapify(heap, currentIndex);
        heapSort(heap, currentIndex);
        String result = "";
        for (int i = currentIndex - 1; i >= 0; i--) {
            result += genRepeatString(heap[i].c, heap[i].count);
        }
        return result;
    }

    private void heapify(CharacterFrequency[] heap, int count) {
        int lastParent = count / 2 - 1;
        while (lastParent >= 0) {
            siftDown(heap, lastParent, count - 1);
            lastParent --;
        }
    }

    private void heapSort(CharacterFrequency[] heap, int count) {
        if (count <= 1) return;
        swap(heap, 0, count - 1);
        siftDown(heap, 0, count - 2);
        heapSort(heap, count - 1);
    }

    private void siftDown(CharacterFrequency[] heap, int start, int end) {
        int index = start;
        while (index * 2 + 1 <= end) {
            int leftChild = index * 2 + 1;
            int maxPos = index;
            if (heap[maxPos].count < heap[leftChild].count) maxPos = leftChild;
            if (leftChild + 1 <= end && heap[leftChild + 1].count > heap[maxPos].count) maxPos = leftChild + 1;
            if (maxPos == index) return;
            swap(heap, index, maxPos);
            index = maxPos;
        }
    }

    private void swap(CharacterFrequency[] heap, int i, int j) {
        CharacterFrequency tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    private String genRepeatString(char c, int count) {
        char[] repeat = new char[count];
        Arrays.fill(repeat, c);
        return new String(repeat);
    }

    private class CharacterFrequency {
        public char c;
        public int count = 0;

        public CharacterFrequency(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    private String solveWithArray(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }
        String[] strings = new String[s.length() + 1];
        int maxOccur = 0;
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            maxOccur = maxOccur > e.getValue() ? maxOccur : e.getValue();
            String current = strings[e.getValue()];
            if (current == null || current.length() == 0) current = "" + e.getKey();
            else current += e.getKey();
            strings[e.getValue()] = current;
        }
        String result = "";
        for (int i = maxOccur; i > 0; i--) {
            if (strings[i] == null) continue;
            for (int j = 0; j < strings[i].length(); j++) {
                result += genRepeatString(strings[i].charAt(j), i);
            }
        }
        return result;
    }
}
