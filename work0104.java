package Leetcode.smart;

import java.util.Stack;

public class work0104 {
	public int maxDepth(TreeNode root) {
		return root==null?0:Math.max(root.left==null?0:maxDepth(root.left),root.right==null?0:maxDepth(root.right))+1;
	}
	public static void main(String[] args) {
		work0104 w= new work0104();
		TreeNode p = TreeNode.treeNode(0);
		System.out.println(w.maxDepth(p));
	}
}
