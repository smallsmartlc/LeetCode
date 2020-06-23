package Leetcode.smart;


public class work0101 {
	public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
	public boolean isMirror(TreeNode left,TreeNode right) {
		if(left==null&&right==null) return true;
		if(left==null||right==null) return false;
		return left.val==right.val && isMirror(left.left, right.right) &&isMirror(left.right, right.left);
	}
	public static void main(String[] args) {
		work0101 w= new work0101();
		TreeNode p = TreeNode.treeNode(1,2,2,3,4,4,3);
		System.out.println(w.isSymmetric(p));
	}
}
