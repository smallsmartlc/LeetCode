package Leetcode.smart;

import java.util.LinkedList;
import java.util.Stack;

/**
 * LeetCode0156 上下翻转二叉树(会员)
 * LintCode0649 二叉树翻转
 */

public class work0156 {
	public static void main(String[] args) {
		work0156 w= new work0156();
		TreeNode root = TreeNode.treeNode(1, 2, 3, 4, 5);
		System.out.println(root);
		System.out.println(w.upsideDownBinaryTree(root));
	}

	public TreeNode upsideDownBinaryTree(TreeNode root) {
		// write your code here
		if(root == null) return root;
		Stack<TreeNode> stack = new Stack<>();
		while (root.left!=null){
			stack.push(root);
			root = root.left;
		}
		stack.push(root);
		while (!stack.empty()){
			TreeNode temp = stack.pop();
			if(!stack.empty()){
				temp.left = stack.peek().right;
				temp.right = stack.peek();
			}else {
				temp.left = null;
				temp.right = null;
			}
		}
		return root;
	}
}
