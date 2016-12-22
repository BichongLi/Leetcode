package com.leetcode.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: BichongLi
 * Date: 12/22/2016
 * Time: 9:40 AM
 */
public class TopKFrequent implements BiSolution<int[], Integer, List<Integer>> {

    @Override
    public List<Integer> solve(int[] nums, Integer k) {
        ElementFrequency[] frequencies = new ElementFrequency[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        int numCount = 0;
        for (int num : nums) {
            if (map.containsKey(num)) frequencies[map.get(num)].increaseCount();
            else {
                frequencies[numCount] = new ElementFrequency(num, 1);
                map.put(num, numCount++);
            }
        }
        ElementFrequency[] heap = new ElementFrequency[k];
        int currentCount = 0;
        for (int i = 0; i < numCount; i++) {
            currentCount = addToHeap(heap, frequencies[i], currentCount, k);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ElementFrequency frequency = getMin(heap, currentCount);
            if (frequency == null) break;
            currentCount--;
            result.add(frequency.element);
        }
        return result;
    }

    private int addToHeap(ElementFrequency[] heap, ElementFrequency frequency, int currentCount, int size) {
        if (currentCount < size) {
            heap[currentCount] = frequency;
            siftUp(heap, currentCount++);
            return currentCount;
        }
        ElementFrequency root = heap[0];
        if (root.count < frequency.count) {
            heap[0] = frequency;
            siftDown(heap, 0, size);
        }
        return currentCount;
    }

    private ElementFrequency getMin(ElementFrequency[] heap, int currentCount) {
        if (currentCount == 0) return null;
        swap(heap, 0, currentCount - 1);
        heapify(heap, currentCount - 1);
        return heap[currentCount - 1];
    }

    private void heapify(ElementFrequency[] heap, int size) {
        int start = size / 2 - 1;
        while (start >= 0) {
            siftDown(heap, start, size);
            start --;
        }
    }

    private void siftUp(ElementFrequency[] heap, int index) {
        int parentIndex = (index - 1) / 2;
        while (parentIndex >= 0) {
            if (heap[parentIndex].count > heap[index].count) {
                swap(heap, index, parentIndex);
                index = parentIndex;
                parentIndex = (index - 1) / 2;
            } else break;
        }
    }

    private void siftDown(ElementFrequency[] heap, int index, int size) {
        int leftChild = index * 2 + 1;
        while (leftChild < size) {
            int minPos = heap[leftChild].count > heap[index].count ? index : leftChild;
            if (leftChild + 1 < size) minPos = heap[leftChild + 1].count > heap[minPos].count ? minPos : leftChild + 1;
            if (minPos == index) return;
            swap(heap, index, minPos);
            index = minPos;
            leftChild = index * 2 + 1;
        }
    }

    private void swap(ElementFrequency[] heap, int a, int b) {
        ElementFrequency tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }

    private class ElementFrequency {
        public int element;
        public int count;

        public ElementFrequency(int element, int count) {
            this.element = element;
            this.count = count;
        }

        public void increaseCount() {
            this.count ++;
        }
    }
}
