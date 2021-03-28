package Leetcode.smart;


import java.util.List;
import java.util.NoSuchElementException;

/**
 * leetcode 0285 二叉搜索树中的中序后继
 * lintcode 448. 二叉查找树的中序后继
 */
public class work0285 {

    public static void main(String[] args) {
        work0285 w = new work0285();
        TreeNode root = new TreeNode(2, 1, 3);
        System.out.println(w.inorderSuccessor(root, root.left));
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        TreeNode res = null;
        while (root != null) {
            if (p.val < root.val) {
                res = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }
}

