package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;

/**
 * 226. 二叉搜索树中第K小的元素
 */
public class work0230 {

    public static void main(String[] args) {

        work0230 w = new work0230();
        TreeNode treeNode = TreeNode.treeNode(3, 1, 4, null, 2);
        System.out.println(w.kthSmallest(treeNode, 1));
    }


    private List<TreeNode> list = new ArrayList<>();

    // 二叉搜索树中序遍历为顺序
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        return list.get(k-1).val;
    }

    private void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        list.add(root);
        inOrder(root.right);
    }
}

