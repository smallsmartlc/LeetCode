package Leetcode.smart;


public class work0110 {
	public static void main(String[] args) {
		work0110 w= new work0110();
		TreeNode dif = TreeNode.treeNode(1,2,2,3,null,null,3,4,null,null,4);
		System.out.println(w.isBalanced(dif));
	}
	public boolean isBalanced(TreeNode root) {
		if(root==null) return true;
		int left = dif(root.left);
		int right = dif(root.right);
		return  Math.abs(left-right)<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }
	private int dif(TreeNode root) {
		if(root==null) return 0 ;
		return Math.max(dif(root.left), dif(root.right))+1;
	}
}
