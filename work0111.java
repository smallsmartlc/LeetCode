package Leetcode.smart;


public class work0111 {
	public int minDepth(TreeNode root) {
		if(root==null) return 0 ;
		if ((root.left == null) && (root.right == null)) {
			return 1;
		}
		int min = Integer.MAX_VALUE;
		if(root.left!=null) min = Integer.min(min,minDepth(root.left));
		if(root.right!=null) min= Integer.min(min,minDepth(root.right));
		return min+1;
    }
	public static void main(String[] args) {
		work0111 w= new work0111();
		TreeNode p = TreeNode.treeNode(1,2);
		System.out.println(w.minDepth(p));
	}
}
