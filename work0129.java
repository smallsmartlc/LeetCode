package Leetcode.smart;


public class work0129 {
	public int sumNumbers(TreeNode root) {
        return dif(root, 0);
    }

	public int dif(TreeNode root, int i) {
		if (root == null) {
			return 0;
		}
		int temp = i * 10 + root.val;
		if (root.left == null && root.right == null) {
			return temp;
		}
		return dif(root.left, temp) + dif(root.right, temp);
	}
	public static void main(String[] args) {
		work0129 w= new work0129();
		TreeNode root = TreeNode.treeNode(1,0);
		System.out.println(w.sumNumbers(root));
	}
}
