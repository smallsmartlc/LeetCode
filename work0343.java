package Leetcode.smart;

//343. 整数拆分

import java.util.HashMap;
import java.util.Map;

public class work0343 {
    public static void main(String[] args) {
        work0343 w = new work0343();

        System.out.println(w.integerBreak(2));


    }
    public int integerBreak(int n) {
        // todo 不是最佳题解
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 2; j < i; j++) {
                max = Math.max(max,Math.max((i-j)*j,j*dp[i-j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }

}