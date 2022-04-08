package Leetcode.smart;

import java.util.*;

/**
 * 0429 N 叉树的层序遍历
 */

public class work0429 {
    public static void main(String[] args) {
        work0429 w = new work0429();
        w.run();
    }

    private void run() {
        levelOrder(new Node());
    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return Collections.EMPTY_LIST;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        while (queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                list.add(poll.val);
                queue.addAll(poll.children);
            }
            res.add(list);
        }
        return res;
    }

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}