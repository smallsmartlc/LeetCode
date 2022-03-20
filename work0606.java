package Leetcode.smart;

/**
 * 0606 根据二叉树创建字符串
 */

public class work0606 {
    public static void main(String[] args) {
        work0606 w = new work0606();
        System.out.println(w.tree2str(TreeNode.treeNode(1, 2, 3, null, 4)));
    }

    public String tree2str(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if (root.left == null && root.right == null) return sb.toString();
        sb.append('(').append(tree2str(root.left)).append(')');
        if (root.right == null) return sb.toString();
        sb.append('(').append(tree2str(root.right)).append(')');
        return sb.toString();
    }
}