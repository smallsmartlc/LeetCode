package Leetcode.smart;


public class work0114 {
	public void flatten(TreeNode root) {
        while(root!=null) {
        	if(root.left==null) {
        		root = root.right;
        	}else {
        		TreeNode pre = root.left;
        		while(pre.right!=null) {
        			pre = pre.right;
        		}
        		pre.right = root.right;
        		root.right = root.left;
        		root.left =null;
        		root = root.right;
        	}
        }
    }
	public static void main(String[] args) {
		work0114 w= new work0114();
		TreeNode p = TreeNode.treeNode(5,4,8,11,null,13,4,7,2,null,null,null,null,5,1);
		w.flatten(p);
		System.out.println();
	}
}
