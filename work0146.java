package Leetcode.smart;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// 0146 LRU缓存
public class work0146 {
    public static void main(String[] args) {
        work0146 w = new work0146();
        w.run();
    }

    private void run() {
        LRUCache0 obj = new LRUCache0(3);
        obj.put(2, 2);
        int param_1 = obj.get(2);
        obj.put(1, 1);
        System.out.println(param_1);
    }

    private class LRUCache {

        private class Node {
            int key;
            int value;
            Node pre;
            Node next;

            public Node() {
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private int capacity;
        private Map<Integer, Node> map;
        private Node head;
        private Node tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity);
            head = new Node();
            tail = new Node(); //哨兵节点
            head.next = tail;
            tail.next = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) return -1;
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                node.value = value;
                moveToHead(node);
            } else {
                node = new Node(key, value);
                map.put(key, node);
                node.pre = head;
                node.next = head.next;
                head.next = node;
                node.next.pre = node;
                if (map.size() > capacity) {
                    node = tail.pre;
                    tail.pre = node.pre;
                    node.pre.next = tail;
                    node.pre = null;
                    node.next = null;
                    map.remove(node.key);
                }
            }
        }

        private void moveToHead(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.next = head.next;
            head.next = node;
            node.pre = head;
            node.next.pre = node;
        }
    }

    private class LRUCache0 {
        private LinkedHashMap<Integer, Integer> map;
        private int capacity;

        public LRUCache0(int capacity) {
            map = new LinkedHashMap<>(capacity) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return size() > capacity;
                }
            };
            this.capacity = capacity;
        }

        public int get(int key) {
            return map.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            map.put(key, value);
        }
    }
}