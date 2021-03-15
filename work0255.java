package Leetcode.smart;


import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 252. 验证前序遍历序列二叉搜索树
 * lintcode 1308. 验证二叉搜索树中的前序序列
 */
public class work0255 {

    public static void main(String[] args) {
        work0255 w = new work0255();
        System.out.println(w.verifyPreorder(new int[]{1, 2}));
    }

    public boolean verifyPreorder(int[] preorder) {
        // write your code here
        return dfs(preorder, 0, preorder.length - 1);
    }

    private boolean dfs(int[] preorder, int i, int j) {
        if (i >= j) return true;
        int root = preorder[i];
        int k = i + 1;
        while (k <= j && preorder[k] < root) k++;
        for (int m = k; m <= j; m++) {
            if (preorder[m] < root) return false;
        }
        return dfs(preorder, i + 1, k - 1) && dfs(preorder, k, j);
    }
}

