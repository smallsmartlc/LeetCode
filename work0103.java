package Leetcode.smart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class work0103 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }
        Boolean flag = true;
        while (!q.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode poll = q.poll();
                if (flag) {
                    list.add(poll.val);
                } else {
                    list.addFirst(poll.val);
                }
                if (poll.left != null) q.add(poll.left);
                if (poll.right != null) q.add(poll.right);
            }
            res.add(list);
            flag = !flag;
        }
        return res;
    }

    public static void main(String[] args) {
        work0103 w = new work0103();
        TreeNode p = TreeNode.treeNode(3, 9, 20, null, null, 15, 7);
        System.out.println(w.zigzagLevelOrder(p));
    }
}
