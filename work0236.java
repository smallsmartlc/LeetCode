package Leetcode.smart;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 236.二叉树的最近公共祖先
 */
public class work0236 {

    public static void main(String[] args) {

        work0236 w = new work0236();
        TreeNode root = TreeNode.treeNode(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        TreeNode p = root.left;
        TreeNode q = root.right;
        System.out.println(w.lowestCommonAncestor(root, p, q));
    }

    Map<TreeNode, TreeNode> map = new HashMap<>();
    Set<TreeNode> set = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            set.add(p);
            p = map.get(p);
        }
        while (q != null) {
            if (set.contains(q)) {
                return q;
            }
            q = map.get(q);
        }
        return null;
    }

    private void dfs(TreeNode root) {
        if (root.left != null) {
            map.put(root.left, root);
            dfs(root.left);
        }
        if (root.right != null) {
            map.put(root.right, root);
            dfs(root.right);
        }
    }

}

