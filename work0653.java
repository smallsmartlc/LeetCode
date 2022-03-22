package Leetcode.smart;

import java.util.Stack;

/**
 * 0653 两数之和 IV - 输入 BST
 */

public class work0653 {
    public static void main(String[] args) {
        work0653 w = new work0653();
        System.out.println(w.findTarget(TreeNode.treeNode(2, 0, 3, -4, 1), -1));
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        Stack<TreeNode> lStack = new Stack<>();
        Stack<TreeNode> rStack = new Stack<>();
        TreeNode cur = root;
        while (cur != null) {
            lStack.push(cur);
            cur = cur.left;
        }
        cur = root;
        while (cur != null) {
            rStack.push(cur);
            cur = cur.right;
        }
        TreeNode l = lStack.peek();
        TreeNode r = rStack.peek(); // 双指针
        while (l.val < r.val) {
            int sum = l.val + r.val;
            if (sum == k) return true;
            if (sum < k) {
                TreeNode right = lStack.pop().right;
                while (right != null) {
                    lStack.push(right);
                    right = right.left;
                }
                l = lStack.peek();
            } else {
                TreeNode left = rStack.pop().left;
                while (left != null) {
                    rStack.push(left);
                    left = left.right;
                }
                r = rStack.peek();
            }
        }
        return false;
    }
}