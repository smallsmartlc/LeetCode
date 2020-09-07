package Leetcode.smart;
/**
 * ¶þ²æÊ÷µÄÇ°Ðò±éÀú
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class work0144 {
	public List<Integer>  preorderTraversal(TreeNode root){
		//½èÖúÕ»µü´ú
		List<Integer> res = new ArrayList<>();
		if (root==null) return res;
		Stack < TreeNode > stack = new Stack < > ();
		TreeNode cur = root;
		stack.add(root);
		while(!stack.empty()) {
			cur = stack.pop();
			res.add(cur.val);
			if(cur.right!=null) {
				stack.push(cur.right);
			}
			if(cur.left!=null) {
				stack.push(cur.left);
			}
		}
		return res;
	}

	List<Integer> res = new ArrayList<>();
	public List<Integer> preorderTraversal2(TreeNode root) {
		//µÝ¹é
		dif(root);
		return res;
    }
	private void dif(TreeNode root) {
		if(root==null) return;
		res.add(root.val);
		if(root.left!=null) {
			dif(root.left);
		}
		if (root.right!=null) {
			dif(root.right);
		}
	}
	public static void main(String[] args) {
		work0144 w= new work0144();
		TreeNode tree = new TreeNode(1,null,2,3);
		TreeNode tree2 = new TreeNode(1,2,3,null,4,null,null,5,null,null,6,7,null,8);
		System.out.println(w.preorderTraversal2(tree2));
		System.out.println(w.preorderTraversal(tree2));
	}
}
