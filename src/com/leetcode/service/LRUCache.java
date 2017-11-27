package com.leetcode.service;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, DoubleListNode> map;
    private int capacity;
    private DoubleListNode head;
    private DoubleListNode tail;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        head = null;
        tail = null;
    }

    public int get(int key) {
        DoubleListNode node = map.get(key);
        if (node == null) return -1;
        moveNodeToTail(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoubleListNode node = map.get(key);
            node.val = value;
            moveNodeToTail(node);
        } else {
            if (map.size() == capacity) {
                map.remove(head.key);
                head = head.next;
                if (head != null) head.prev = null;
            }
            DoubleListNode node = new DoubleListNode(key, value);
            map.put(key, node);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }
    }

    private void moveNodeToTail(DoubleListNode node) {
        if (node == tail) return;
        if (node == head) head = node.next;
        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
        node.prev = tail;
        tail.next = node;
        node.next = null;
        tail = node;
    }

    private class DoubleListNode {
        int key;
        int val;
        DoubleListNode next;
        DoubleListNode prev;

        DoubleListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}
