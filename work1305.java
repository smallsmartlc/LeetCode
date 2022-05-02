package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 1305 两棵二叉搜索树中的所有元素
 *
 * @author LuCong
 * @since 2022-5-1
 **/
public class work1305 {
    public static void main(String[] args) {
        work1305 w = new work1305();
        System.out.println(w.getAllElements(
                TreeNode.treeNode(2, 1, 4),
                TreeNode.treeNode(1, 0, 3)
        ));
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while (!stack1.isEmpty() || !stack2.isEmpty() || root1 != null || root2 != null) {
            while (root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            }
            while (root2 != null) {
                stack2.push(root2);
                root2 = root2.left;
            }
            root1 = stack1.isEmpty() ? null : stack1.peek();
            root2 = stack2.isEmpty() ? null : stack2.peek();
            if (root1 != null && root2 != null) {
                if (root1.val > root2.val) {
                    res.add(root2.val);
                    root2 = root2.right;
                    stack2.pop();
                    root1 = null;
                } else {
                    res.add(root1.val);
                    root1 = root1.right;
                    stack1.pop();
                    root2 = null;
                }
            } else if (root1 != null) {
                res.add(root1.val);
                root1 = root1.right;
                stack1.pop();
            } else if (root2 != null) {
                res.add(root2.val);
                root2 = root2.right;
                stack2.pop();
            }
        }
        return res;
    }
}







