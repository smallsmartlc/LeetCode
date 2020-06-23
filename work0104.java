package Leetcode.smart;

import java.util.Stack;

public class work0104 {
	public int maxDepth(TreeNode root) {
		if(root==null) return 0 ;
		int depth = 0;
		if(root.left!=null) depth = maxDepth(root.left)+1;
		if(root.right!=null) depth = Math.max(depth, maxDepth(root.right))+1;
		return depth;
    }
	public static void main(String[] args) {
		work0104 w= new work0104();
		TreeNode p = TreeNode.treeNode(0);
		System.out.println(w.maxDepth(p));
	}
}
