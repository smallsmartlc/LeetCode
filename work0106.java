package Leetcode.smart;

import java.util.HashMap;
import java.util.Map;

public class work0106 {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(postorder, postorder, 0, postorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int inleft, int inright, int postleft, int postright) {
        if (inleft > inright) {
            return null;
        }
        int root = postorder[postright];
        int length = inright - map.get(root);
        TreeNode res = new TreeNode(root);
        if (length > 0) {
            res.right = build(inorder, postorder, map.get(root) + 1, inright, postleft - length, postright - 1);
        }
        if (map.get(root) - inleft > 0) {
            res.left = build(inorder, postorder, inleft, inright - length - 1, postleft, postright - length - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        work0106 w = new work0106();
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        TreeNode res = w.buildTree(inorder, postorder);
        System.out.println();
    }
}
