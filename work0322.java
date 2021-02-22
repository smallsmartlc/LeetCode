package Leetcode.smart;

import java.util.Arrays;

/**
 * LeetCode0322 零钱兑换
 */

public class work0322 {
    public static void main(String[] args) {
        work0322 w = new work0322();
        System.out.println(w.coinChange1(new int[]{1, 2, 5}, 11));
    }

    public int coinChange(int[] coins, int amount) {
        //动态规划
        if (amount < 1) return 0;
        int[] dp = new int[amount + 1];
        int max = amount + 1;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] < coins.length) dp[coins[i]]++;
        }
        for (int i = 1; i <= amount; i++) {
            dp[i] = max;
            for (int j = 0; j < coins.length; j++) {
                if (i < coins[j]) continue;
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int coinChange1(int[] coins, int amount) {
        // 记忆化递归+剪枝好像更快
        if(amount < 1)return 0;
        Arrays.sort(coins);
        res = amount+1;
        dfs(coins,amount,0,coins.length-1);
        return res > amount?-1:res;
    }
    private int res;
    private void dfs(int[] coins, int amount,int count,int index){
        if(amount == 0) {
            res = Math.min(res,count);
            return;
        }
        if(index < 0) return;
        for(int i = amount/coins[index];i>=0 && i+count<res; i--){
            dfs(coins,amount - (i*coins[index]), count + i, index-1);
        }
    }
}