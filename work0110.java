package Leetcode.smart;


public class work0110 {
	public static void main(String[] args) {
		work0110 w= new work0110();
		TreeNode dif = TreeNode.treeNode(1,2,2,3,null,null,3,4,null,null,4);
		System.out.println(w.isBalanced(dif));
	}
	public boolean isBalanced(TreeNode root) {
		return root == null || (Math.abs(dfs(root.left) - dfs(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right));
	}
	private int dfs(TreeNode node) {
		return node == null ? 0 : Math.max(dfs(node.left), dfs(node.right)) + 1;
	}
}
