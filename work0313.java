package Leetcode.smart;

/**
 * LeetCode0313 超级丑数
 */

public class work0313 {
    public static void main(String[] args) {
        work0313 w = new work0313();
        System.out.println(w.nthSuperUglyNumber(12, new int[]{2,7,13,19}));
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        int[] p = new int[primes.length];
        for (int i = 1; i < n; i++) {
            int ugly = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                ugly = Math.min(dp[p[j]]*primes[j],ugly);
            }
            dp[i] = ugly;
            for (int j = 0; j < primes.length; j++) {
                if(ugly == dp[p[j]] * primes[j]) p[j]++;
            }
        }
        return dp[n-1];
    }
}