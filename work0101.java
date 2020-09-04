package Leetcode.smart;


import java.util.Stack;

public class work0101 {

    public boolean isSymmetric2(TreeNode root) {
        //迭代
        Stack<TreeNode> q = new Stack<>();
        TreeNode u = root;
        TreeNode v = root;
        q.push(u);
        q.push(v);
        while (!q.isEmpty()) {
            u = q.pop();
            v = q.pop();
            if (u == null && v == null) {
                continue;
            }
            if (u == null || v == null || u.val != v.val){
                return false;
            }
            q.push(u.left);
            q.push(v.right);
            q.push(u.right);
            q.push(v.left);
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        //递归
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val == right.val) {
            return isMirror(left.right, right.left) && isMirror(left.left, right.right);
        }
        return false;
    }

    public static void main(String[] args) {
        work0101 w = new work0101();
        TreeNode p = TreeNode.treeNode(1, 2, 2, 3, 4, 4, 3);
        System.out.println(w.isSymmetric(p));
        System.out.println(w.isSymmetric2(p));
    }
}
