package Leetcode.smart;


public class work0111 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        sum -= root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    public static void main(String[] args) {
        work0111 w = new work0111();
        TreeNode p = TreeNode.treeNode(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1);
        System.out.println(w.hasPathSum(p, 22));
    }
}
