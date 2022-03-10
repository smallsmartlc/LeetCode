package Leetcode.smart;

import java.util.*;

/**
 * 0589 N 叉树的前序遍历
 */

public class work0589 {
    public static void main(String[] args) {
        work0589 w = new work0589();
    }

    public List<Integer> preorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            for (int i = node.children.size()-1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return res;
    }

    public List<Integer> preorder(Node root) { // 递归
        if (root == null) return Collections.emptyList();
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        for (Node child : root.children) {
            res.addAll(preorder(child));
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

    ;

}