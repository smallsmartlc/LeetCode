package Leetcode.smart;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 0432 全 O(1) 的数据结构
 */

public class work0432 {
    public static void main(String[] args) {
        work0432 w = new work0432();
        w.run();
    }

    private void run() {
        AllOne a = new AllOne();
        a.inc("a");
//        a.inc("goodbye");
        a.inc("b");
        a.inc("b");
        a.inc("c");
        a.inc("c");
        a.dec("c");
        a.dec("b");
        a.dec("b");
        a.dec("a");
        System.out.println(a.getMaxKey());
        System.out.println(a.getMinKey());
    }

    private class AllOne {

        HashMap<String, Node> map;
        Node head;
        Node tail;

        public AllOne() {
            map = new HashMap<>();
            head = new Node(); //哨兵
            tail = new Node(); // 尾部
            head.next = tail;
            tail.pre = head;
        }

        public void inc(String key) {
            Node node = map.get(key);
            if (node == null) {
                if (head.next.count == 1) {
                    head.next.key.add(key);
                    map.put(key, head.next);
                } else {
                    node = new Node(1);
                    node.key.add(key);
                    node.pre = head;
                    node.next = head.next;
                    head.next = node;
                    node.next.pre = node;
                    map.put(key, node);
                }
            } else {
                if (node.next.count == node.count + 1) { //有合适的
                    node.next.key.add(key);
                } else { // 插入一个节点
                    Node n = new Node(node.count + 1);
                    n.key.add(key);
                    n.pre = node;
                    n.next = node.next;
                    node.next = n;
                    n.next.pre = n;
                }
                map.put(key, node.next);
                if (node.key.size() == 1) { //删除原节点
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                } else {
                    node.key.remove(key);
                }
            }
        }

        public void dec(String key) {
            Node node = map.get(key);
            node.key.remove(key);
            if (node.count != 1) {
                if (node.pre.count == node.count - 1) {
                    node.pre.key.add(key);
                } else { //插入一个节点
                    Node insert = new Node(node.count - 1);
                    insert.key.add(key);
                    insert.next = node;
                    insert.pre = node.pre;
                    node.pre.next = insert;
                    node.pre = insert;
                }
                map.put(key,node.pre);
            } else {
                map.remove(key);
            }
            if (node.key.isEmpty()) {
                node.pre.next = node.next; //删除节点
                node.next.pre = node.pre;
            }
        }

        public String getMaxKey() {
            return tail.pre.key == null ? "" : tail.pre.key.iterator().next();
        }

        public String getMinKey() {
            return head.next.key == null ? "" : head.next.key.iterator().next();
        }
    }

    class Node {
        Node pre;
        Node next;
        Set<String> key;
        int count;

        public Node() {
        }

        public Node(int count) {
            this.key = new HashSet<>();
            this.count = count;
        }
    }


    private class AllOne0 {

        HashMap<String, Node0> map;
        Node0 head;
        Node0 tail;

        public AllOne0() {
            map = new HashMap<>();
            head = new Node0(null, -1); //哨兵
            tail = new Node0(null, Integer.MAX_VALUE); // 尾部
            head.next = tail;
            tail.pre = head;
        }

        public void inc(String key) {
            Node0 node = map.get(key);
            if (node == null) {
                node = new Node0(key, 1);
                node.pre = head;
                node.next = head.next;
                head.next = node;
                node.next.pre = node;
                map.put(key, node);
            } else {
                node.count++;
                while (node.next.count < node.count) {
                    Node0 pre = node.pre;
                    Node0 next = node.next;
                    pre.next = next;
                    next.pre = pre;
                    node.pre = next;
                    node.next = next.next;
                    next.next = node;
                    node.next.pre = node;
                }
            }
        }

        public void dec(String key) {
            Node0 node = map.get(key);
            node.count--;
            if (node.count == 0) {
                node.pre.next = node.next;
                node.next.pre = node.pre;
                node.next = null;
                node.pre = null;
                map.remove(key);
            } else {
                while (node.count < node.pre.count) {
                    Node0 pre = node.pre;
                    Node0 p = pre.pre;
                    p.next = node;
                    node.pre = p;
                    pre.pre = node;
                    pre.next = node.next;
                    node.next.pre = pre;
                    node.next = pre;
                }
            }
        }

        public String getMaxKey() {
            return tail.pre.key == null ? "" : tail.pre.key;
        }

        public String getMinKey() {
            return head.next.key == null ? "" : head.next.key;
        }
    }

    private class Node0 {
        Node0 pre;
        Node0 next;
        String key;
        int count;

        public Node0() {
        }

        public Node0(String key, int count) {
            this.key = key;
            this.count = count;
        }
    }
}