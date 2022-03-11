package Leetcode.smart;

import java.util.Arrays;

/**
 * 2049 统计最高分的节点数目
 *
 * @author LuCong
 * @since 2022-2-9
 **/
public class work2049 {
    public static void main(String[] args) {
        work2049 w = new work2049();
        System.out.println(w.countHighestScoreNodes(new int[]{-1,2,0}));
    }

    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        dp = new int[n];
        left = new int[n];
        right = new int[n];
        Arrays.fill(left, -2);
        Arrays.fill(right, -2);
        for (int i = 1; i < n; i++) {
            if (left[parents[i]] == -2) {
                left[parents[i]] = i;
            } else {
                right[parents[i]] = i;
            }
        }
        dfs(0);// 统计所有节点的数量
        long max = 0;
        int num = 0;
        for (int i = 0; i < n; i++) {
            long ans = 1;
            if (parents[i] != -1) {
                ans *= dp[0] - dp[i]; // 根节点减去当前节点等于这个节点上面的其它树
            }
            if (left[i] != -2) {
                ans *= dp[left[i]];
                if (right[i] != -2) {
                    ans *= dp[right[i]];
                }
            }
            if (ans > max) {
                max = ans;
                num = 1;
            } else if (ans == max) {
                num++;
            }
        }
        return num;
    }

    private int[] dp;
    private int[] left;
    private int[] right;

    private int dfs(int root) { // 子节点数量
        int res = 1;
        if (left[root] != -2) {
            res += dfs(left[root]);
            if (right[root] != -2) res += dfs(right[root]);
        }
        dp[root] = res;
        return res;
    }
}


