package Leetcode.smart;


public class work0100 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null&&q==null) return true;
		if(p==null) return false;
		if(q==null) return false;
		if(p.val==q.val) {
			if(isSameTree(p.left, q.left)&&isSameTree(p.right, q.right)) return true;
		}
		return false;
    }
	public static void main(String[] args) {
		work0100 w= new work0100();
		TreeNode p = TreeNode.treeNode(10,5,15);
		TreeNode q = TreeNode.treeNode(10,5,null,null,15);
		System.out.println(w.isSameTree(p, q));
	}
}
