package Leetcode.smart;


/**
 * LeetCode0375 猜数字大小 II
 */
public class work0375 {
    public static void main(String[] args) {
        work0375 w = new work0375();
        System.out.println(w.getMoneyAmount(10));
        System.out.println(w.getMoneyAmount2(10));
    }

    public int getMoneyAmount2(int n) {
        int[][] dp = new int[n + 2][n + 2]; // 用于处理数组因为加一越界后的空值
        for (int i = 2; i <= n; i++) { // 较大的那个数
            for (int j = i - 1; j > 0; j--) { // 从(1,2)开始
                int min = Integer.MAX_VALUE;
                for (int k = j; k <= i; k++) { // (i,j)遍历
                    min = Math.min(min,Math.max(dp[j][k-1],dp[k+1][i])+k);
                }
                dp[j][i] = min;
            }
        }
        return dp[1][n];
    }


    public int getMoneyAmount(int n) {
        return getMoney(1, n);
    }

    private static int[][] dp = new int[201][201]; // 记忆化递归

    private int getMoney(int s, int n) {
        if (s >= n) return 0;
        if (n - s == 1) return s;
        if (dp[s][n] != 0) return dp[s][n];
        int min = Integer.MAX_VALUE;
        for (int i = s; i < n; i++) {
            min = Math.min(min, i + Math.max(getMoney(s, i - 1), getMoney(i + 1, n)));
        }
        dp[s][n] = min;
        return min;
    }
}