package Leetcode.smart;

import java.util.HashMap;
import java.util.Map;

public class work0105 {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int preindex, int preend, int inindex, int inend) {
        if (preindex > preend) {
            return null;
        }
        int root = preorder[preindex];
        int length = map.get(root) - inindex;
        TreeNode res = new TreeNode(root);
        if (length > 0) {
            res.left = build(preorder, inorder, preindex + 1, preindex + length, inindex, map.get(root) - 1);
        }
        if (preindex + length < preend) {
            res.right = build(preorder, inorder, preindex + length + 1, preend, map.get(root) + 1, inend);
        }
        return res;
    }

    public static void main(String[] args) {
        work0105 w = new work0105();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode res = w.buildTree(preorder, inorder);
        System.out.println();
    }
}
