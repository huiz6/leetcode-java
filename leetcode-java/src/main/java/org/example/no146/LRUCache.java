package org.example.no146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private final int capacity;

    private final Map<Integer, Node<Integer>> map;

    private final DoubleLinkedList<Integer> doubleLinkedList;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.doubleLinkedList = new DoubleLinkedList<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node<Integer> node = map.get(key);
            doubleLinkedList.moveToTail(node);
            return node.getValue();
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node<Integer> node = map.get(key);
            node.setValue(value);
            this.doubleLinkedList.moveToTail(node);
        } else {
            if (map.size() == capacity) {
                Node<Integer> headNode = doubleLinkedList.getHead();
                this.map.remove(headNode.getKey());
                this.doubleLinkedList.removeNode(headNode);
            }

            Node<Integer> node = new Node<>(key, value);
            this.map.put(key, node);
            this.doubleLinkedList.add(node);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(2));

    }

}
