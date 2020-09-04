package Leetcode.smart;


public class work0101 {
    public boolean isSymmetric(TreeNode root) {
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
    }
}
