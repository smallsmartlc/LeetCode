package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class work0094 {
	public List<Integer> inorderTraversal(TreeNode root){
		//½èÖúÕ»µü´ú
		List<Integer> res = new ArrayList<>();
		Stack < TreeNode > stack = new Stack < > ();
		TreeNode cur = root;
		while(cur != null||!stack.empty()) {
			while(cur!=null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			res.add(cur.val);
			cur = cur.right;
		}
		return res;
	}
	List<Integer> res = new ArrayList<>();
	public List<Integer> inorderTraversal2(TreeNode root) {
		//µÝ¹é
		dif(root);
		return res;
    }
	private void dif(TreeNode root) {
		if(root==null) return;
		if(root.left!=null) {
			dif(root.left);
		}
		res.add(root.val);
		if (root.right!=null) {
			dif(root.right);
		}
	} 
	public static void main(String[] args) {
		work0094 w= new work0094();
		TreeNode tree = new TreeNode(1,null,2,3);
		TreeNode tree2 = new TreeNode(1,2,3,null,4,null,null,5,null,null,6,7,null,8,null,null);
		System.out.println(tree2.preorderTraversal());
		System.out.println(tree2.inorderTraversal());
		System.out.println(tree2.postorderTraversal());
	}
}
