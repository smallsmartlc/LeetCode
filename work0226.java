package Leetcode.smart;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 226. 翻转二叉树
 */
public class work0226 {

    public static void main(String[] args) {

        work0226 w = new work0226();

        TreeNode treeNode = TreeNode.treeNode(4, 2, 7, 1, 3, 6 ,9);
        System.out.println(treeNode);
        System.out.println(w.invertTree(treeNode));
        System.out.println(w.invertTree2(treeNode));



    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode res = new TreeNode(root.val);
        res.left = invertTree(root.right);
        res.right = invertTree(root.left);
        return res;
    }

    public TreeNode invertTree2(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            TreeNode temp = poll.left;
            poll.left = poll.right;
            poll.right = temp;
            if(poll.left != null) queue.add(poll.left);
            if(poll.right != null) queue.add(poll.right);
        }
        return root;
    }

}

