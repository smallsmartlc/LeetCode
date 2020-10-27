package Leetcode.smart;

//打家劫舍III

import java.util.HashMap;
import java.util.Map;

public class work0337 {
    public static void main(String[] args) {
        work0337 w = new work0337();

//        TreeNode root = TreeNode.treeNode(3, 2, 3, null, 3, null, 1);
        TreeNode root = TreeNode.treeNode(3, 4, 5, 1, 3, null, 1);

        System.out.println(w.rob(root));


    }

    public int rob2(TreeNode root) {
        //动态规划

        int[] res = dp(root);
        return Math.max(res[0], res[1]);

    }

    private int[] dp(TreeNode root) {
        //使用数组保存两个状态,偷或者不偷的最大值
        if (root == null) return new int[]{0, 0};
        int[] left = dp(root.left);
        int[] right = dp(root.right);

        int rob = root.val + left[1] + right[1];
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{rob, notRob};

    }

    private Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {

        //递归 + 备忘录

        if (root == null) return 0;
        if (map.containsKey(root)) {
            return map.get(root);
        }
        //抢,然后去下下家
        int steal = root.val
                + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        //不抢,去下家
        int no_steal = rob(root.left) + rob(root.right);

        int res = Math.max(steal, no_steal);
        //备忘录存储
        map.put(root, res);
        return res;

    }

}