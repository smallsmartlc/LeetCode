package Leetcode.smart;


public class work0098 {
	public boolean isValidBST(TreeNode root) {
		return is(root, null, null);
    }
	public boolean is(TreeNode cur,Integer small,Integer big) {
		if(cur==null) return true;
		if((big!=null&&cur.val>=big)||(small!=null&&cur.val<=small)) {
			return false;
		}
		if(!is(cur.left,small,cur.val)) return false;
		if(!is(cur.right,cur.val,big)) return false;
		return true;
	}
	public static void main(String[] args) {
		work0098 w= new work0098();
		TreeNode root= TreeNode.treeNode(10,5,15,null,null,6,20);
		System.out.println(w.isValidBST(root));
	}
}
