package Leetcode.smart;

/**
 * LeetCode0832 翻转图像
 *
 * @author LuCong
 * @since 2020-10-30
 **/
public class work0338 {
    public static void main(String[] args) {
        work0338 o = new work0338();
        System.out.println(o.countBits(2));
    }

    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i < num + 1; i++) {
            dp[i] = dp[i & i - 1] + 1;
        }
        return dp;
    }
}


