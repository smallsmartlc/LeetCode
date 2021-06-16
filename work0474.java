package Leetcode.smart;

import java.util.Arrays;

/**
 * LeetCode0416 分割等和子集
 */

public class work0474 {
    public static void main(String[] args) {
        work0474 w = new work0474();
        System.out.println(w.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"},
                5,3));
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len+1][m+1][n+1];
        for (int i = 1; i <= len; i++) {
            int[] nums = getNums(strs[i - 1]);
            int num0 = nums[0];
            int num1 = nums[1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if(j >= num0 && k >= num1){
                        dp[i][j][k] = Math.max(dp[i-1][j][k],dp[i-1][j-num0][k-num1] + 1);
                    }else{
                        dp[i][j][k] = dp[i-1][j][k];
                    }
                }
            }
        }
        return dp[len][m][n];
    }
    private int[] getNums(String str){
        //返回String中1和0的数量
        int[] res = new int[2];
        for (int i = 0; i < str.length(); i++) {
            res[str.charAt(i)-'0']++;
        }
        return res;
    }
}