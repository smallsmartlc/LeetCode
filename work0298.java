package Leetcode.smart;

/**
 * LeetCode0298	二叉树最长连续序列
 */
public class work0298 {

    public static void main(String[] args) {

        work0298 w = new work0298();
        TreeNode root = TreeNode.treeNode(1, null, 3, 2, 4, null, null, null, 5);
        System.out.println(w.longestConsecutive(root));
    }

    private int max = 1;

    public int longestConsecutive(TreeNode root) {
        // write your code here
        if (root == null) return 0;
        childNode(root, 1);
        return max;
    }

    private void childNode(TreeNode root, int i) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.left.val - root.val == 1) {
            max = Math.max(max, i + 1);
            childNode(root.left, i + 1);
        } else {
            childNode(root.left, 1);
        }
        if (root.right != null && root.right.val - root.val == 1) {
            max = Math.max(max, i + 1);
            childNode(root.right, i + 1);
        } else {
            childNode(root.right, 1);
        }
    }
}

