package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 0449 序列化和反序列化二叉搜索树
 */

public class work0449 {
    public static void main(String[] args) {
        work0449 w = new work0449();
        w.run();
    }

    private void run() {
        Codec ser = new Codec();
        Codec deser = new Codec();
        TreeNode root = TreeNode.treeNode(2, 1, 3);
        String tree = ser.serialize(root);
        System.out.println(tree);
        TreeNode ans = deser.deserialize(tree);
        System.out.println(ans);
    }


    private class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>(); // 后序遍历
            TreeNode pre = null;
            while (root != null || !stack.isEmpty()) {
                while (root != null) { //左叶子节点
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.right != null && root.right != pre) {
                    stack.push(root);
                    root = root.right; // 继续对右节点遍历
                } else {
                    list.add(root.val);
                    pre = root;
                    root = null;
                }
            }
            String s = list.toString();
            return s.substring(1, s.length() - 1);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;
            String[] split = data.split(", ");
            Stack<Integer> stack = new Stack<>();
            for (String s : split) {
                stack.push(Integer.parseInt(s));
            }
            return construct(Integer.MIN_VALUE,Integer.MAX_VALUE,stack);
        }

        private TreeNode construct(int lower, int upper, Stack<Integer> stack) {
            if (stack.isEmpty() || stack.peek() < lower || stack.peek() > upper) {
                return null;
            }
            int val = stack.pop();
            TreeNode root = new TreeNode(val);
            root.right = construct(val, upper, stack);
            root.left = construct(lower, val, stack);
            return root;
        }
    }
}