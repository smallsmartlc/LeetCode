package Leetcode.smart;


import java.util.*;

/**
 * 257. 二叉树的所有路径
 */
public class work0257 {

    public static void main(String[] args) {

        work0257 w = new work0257();
        TreeNode root = TreeNode.treeNode(1, 2, 3, null, 5);
        System.out.println(w.binaryTreePaths(root));
    }

    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return res;
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        dfs(root,sb);
        return res;
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if(root.left == null && root.right == null){
            res.add(sb.toString());
            return;
        }
        if(root.left != null){
            dfs(root.left,new StringBuilder(sb).append("->").append(root.left.val));
        }
        if(root.right != null){
            dfs(root.right,new StringBuilder(sb).append("->").append(root.right.val));
        }
    }
}

