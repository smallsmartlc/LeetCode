package Leetcode.smart;


public class work0114 {
	public void flatten(TreeNode root) {
        while(root!=null) {
        	if(root.left==null) {
        		root = root.right;
        	}else {
        		TreeNode pre = root.left;
        		while(pre.right!=null) {
        			//遍历到左子树的最右节点
        			pre = pre.right;
        		}
        		//根节点右子树接到左子树最右节点
        		pre.right = root.right;
        		//左子树接到根节点右侧
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
