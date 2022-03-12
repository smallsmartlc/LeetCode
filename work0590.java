package Leetcode.smart;

import java.util.*;

/**
 * 0590 N 叉树的后序遍历
 */

public class work0590 {
    public static void main(String[] args) {
        work0590 w = new work0590();
    }

    public List<Integer> postorder1(Node root) {
        // 迭代,把根节点放在末尾
        if (root == null) return Collections.EMPTY_LIST;
        LinkedList<Integer> res = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.addFirst(node.val);
            for (Node child : node.children) {
                stack.push(child);
            }
        }
        return res;
    }

    public List<Integer> postorder(Node root) {
        if (root == null) return Collections.EMPTY_LIST;
        ArrayList<Integer> res = new ArrayList<>();
        for (Node child : root.children) {
            res.addAll(postorder(child));
        }
        res.add(root.val);
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