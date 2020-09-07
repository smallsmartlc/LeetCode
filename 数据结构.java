package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int x) {
        val = x;
    }

    ListNode(int... x) {
        ListNode n = this;
        n.val = x[0];
        for (int i = 1; i < x.length; i++) {
            n.next = new ListNode(x[i]);
            n = n.next;
        }
    }

    @Override
    public String toString() {
        String str = "" + this.val;
        ListNode n = this;
        while (n.next != null) {
            str += "-->" + n.next.val;
            n = n.next;
        }
        return str;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + (left==null?null:left.val) +
                ", right=" + (right==null?null:right.val) +
                '}';
    }

    TreeNode(Integer... x) {
        //ǰ��
        Stack<Integer> stack = new Stack<>();
        for (int i = x.length - 1; i >= 0; i--) {
            stack.push(x[i]);
        }
        this.val = stack.pop();
        if (!stack.empty()) {
            this.left = creatTree(stack.pop(), stack);
        }
        if (!stack.empty()) {
            this.right = creatTree(stack.pop(), stack);
        }
    }

    private TreeNode creatTree(Integer x, Stack<Integer> stack) {
        if (x == null) return null;
        TreeNode node = new TreeNode(x);
        if (!stack.empty()) {
            node.left = creatTree(stack.pop(), stack);
        }
        if (!stack.empty()) {
            node.right = creatTree(stack.pop(), stack);
        }
        return node;
    }

    public static TreeNode treeNode(Integer... x) {
        return createBinaryTree(0, x);
    }

    private static TreeNode createBinaryTree(int index, Integer... array) {
        // ��������������Χ
        if (index >= array.length) return null;
        // ���鵱ǰֵΪ��
        if (array[index] == null) return null;

        TreeNode treeNode = new TreeNode(array[index]);
//            0 1 2 3 4 5 6
//        arr 1,2,2,3,4,4,3
//              ������������
        //���λ�õ�����  ���㹫ʽ 2n+1
        //�Ҳ�λ�õ�����  ���㹫ʽ 2n+2
        treeNode.left = createBinaryTree(2 * index + 1, array);
        treeNode.right = createBinaryTree(2 * index + 2, array);
        return treeNode;
    }

    /**
     * ǰ�����
     *
     * @return
     */
    public List<Integer> preorderTraversal() {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = this;
        stack.add(this);
        while (!stack.empty()) {
            cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return res;
    }

    /**
     * �������
     *
     * @return
     */
    public List<Integer> inorderTraversal() {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = this;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    /**
     * �������
     *
     * @return
     */
    public List<Integer> postorderTraversal() {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = this;
        stack.add(this);
        while (!stack.empty()) {
            cur = stack.pop();
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
            res.add(0, cur.val);
        }
        return res;
    }
}


//Definition for a Node.
//����������
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + (left == null ? null : left.val) +
                ", right=" + (right == null ? null : right.val) +
                ", next=" + (next == null ? null : next.val) +
                "}";
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public static Node node(Integer... x) {
        return createNode(0, x);
    }

    private static Node createNode(int index, Integer... array) {
        // ��������������Χ
        if (index >= array.length) return null;
        // ���鵱ǰֵΪ��
        if (array[index] == null) return null;

        Node node = new Node(array[index]);
//            0 1 2 3 4 5 6
//        arr 1,2,2,3,4,4,3
//              ������������
        //���λ�õ�����  ���㹫ʽ 2n+1
        //�Ҳ�λ�õ�����  ���㹫ʽ 2n+2
        node.left = createNode(2 * index + 1, array);
        node.right = createNode(2 * index + 2, array);
        return node;
    }
}