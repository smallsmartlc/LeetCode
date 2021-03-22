package Leetcode.smart;


import java.util.*;

/**
 * leetcode 0270 最接近的二叉搜索树值
 * lintcode 900. 二叉搜索树中最接近的值
 */
public class work0270 {

    public static void main(String[] args) {
        work0270 w = new work0270();
        TreeNode root = TreeNode.treeNode(5, 4, 9, 2, null, 8, 10);
        System.out.println(w.closestValue(root, 6.124780d));
    }

    public int closestValue(TreeNode root, double target) {
        // write your code here
        int closest = root.val;
        while (root != null) {
            int val = root.val;
            closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
            root = target < root.val ? root.left : root.right;
        }
        return closest;
    }

}

