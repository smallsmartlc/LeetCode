package Leetcode.smart;


/**
 * 250. 统计同值子树
 * lintcode 921. 统计唯一值子树个数
 */
public class work0250 {

    public static void main(String[] args) {

        work0250 w = new work0250();
        TreeNode root = TreeNode.treeNode(1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1);
        System.out.println(root);
        System.out.println(w.countUnivalSubtrees(root));
//        System.out.println(w.countUnivalSubtrees(TreeNode.treeNode(1,3,2,4,5,null,6)));
    }

    private int res = 0;

    private boolean isSubtrees(TreeNode root) {
        if (root == null) return true;
        if (root.left == null || root.right == null) {
            if (root.left == root.right) {
                res++;
                return true;
            }
        }
        boolean left = isSubtrees(root.left);
        boolean right = isSubtrees(root.right);
        if (left && right && root.left == null ? true : root.val == root.left.val && root.right == null ? true : root.val == root.right.val) {
            res++;
            return true;
        }
        return false;
    }

    public int countUnivalSubtrees(TreeNode root) {
        isSubtrees(root);
        return res;
    }

}

