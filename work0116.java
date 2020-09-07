package Leetcode.smart;


public class work0116 {
    public Node connect(Node root) {
        aaa(root, null);
        return root;
    }

    private void aaa(Node root, Node right) {
        if (root == null) return;
        root.next = right;
        aaa(root.left, root.right);
        aaa(root.right, root.next == null ? null : root.next.left);
    }

    public static void main(String[] args) {
        work0116 w = new work0116();
        Node p = Node.node(1, 2, 3, 4, 5, 6, 7);
        Node connect = w.connect(p);
        System.out.println();
    }
}
