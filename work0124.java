package Leetcode.smart;

public class work0124 {

    int maxLen = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxLen;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(dfs(root.left),0);
        int right = Math.max(dfs(root.right),0);

        int curMax = root.val + left + right;

        maxLen = maxLen < curMax ? curMax : maxLen;

        return root.val + Math.max(left,right);

    }

    public static void main(String[] args) {
        work0124 w = new work0124();
        TreeNode root = TreeNode.treeNode(1, 2, 3);
        System.out.println(w.maxPathSum(root));
    }
}
