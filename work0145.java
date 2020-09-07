package Leetcode.smart;
/**
 * 二叉树的后续遍历
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class work0145 {
	public List<Integer>  postorderTraversal(TreeNode root){
		//借助栈迭代
		List<Integer> res = new ArrayList<>();
		if (root==null) return res;
		Stack < TreeNode > stack = new Stack < > ();
		TreeNode cur = root;
		stack.add(root);
		while(!stack.empty()) {
			cur = stack.pop();
			if(cur.left!=null) {
				stack.push(cur.left);
			}
			if(cur.right!=null) {
				stack.push(cur.right);
			}
			res.add(0, cur.val);
		}
		return res;
	}
	List<Integer> res = new ArrayList<>();
	public List<Integer> postorderTraversal2(TreeNode root) {
		//递归
		dif(root);
		return res;
    }

	private void dif(TreeNode root) {
		if (root == null) return;
		if (root.left != null) {
			dif(root.left);
		}
		if (root.right != null) {
			dif(root.right);
		}
		res.add(root.val);
	}
	public static void main(String[] args) {
		work0145 w= new work0145();
		TreeNode tree = new TreeNode(1,null,2,3);
		TreeNode tree2 = new TreeNode(1,2,3,null,4,null,null,5,null,null,6,7,null,8);
		System.out.println(w.postorderTraversal2(tree2));
		System.out.println(w.postorderTraversal(tree2));
	}
}
