package Leetcode.smart;

/**
 * 222. 完全二叉树的节点个数
 */
public class work0222 {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (left == right) {
            return (1 << left) + countNodes(root.right);
        } else {
            return (1 << right) + countNodes(root.left);
        }
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        return getDepth(root.left) + 1;
    }

    public static void main(String[] args) {
        work0222 w = new work0222();
        TreeNode root = TreeNode.treeNode(1, 2, 3, 4, 5, 6);
        System.out.println(w.countNodes(root));
    }
}
