package Leetcode.smart;

import java.util.Arrays;

/**
 * LeetCode0300 最长递增子序列
 */
public class work0300 {

    public static void main(String[] args) {
        work0300 w = new work0300();
        System.out.println(w.lengthOfLIS(7, 7, 7, 7, 7, 7, 7));
    }

    public int lengthOfLIS(int... nums) {
        //动态规划
        if (nums.length < 1) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[j] < nums[i] && dp[i] < dp[j] + 1) dp[i] = dp[j] + 1;
            }
            if (res < dp[i]) res = dp[i];
        }
        return res;
    }

        public int lengthOfLIS2(int... nums) {
            //贪心
            // 优化的思路就是把查找的过程转换为二分
            //我们用dp[i] 存储长度为i时 末尾数的最小值
            // 这样就能保证dp数组是递增的,就可以用二分法查找
            if (nums.length < 1) return 0;
            int[] dp = new int[nums.length + 1];
            int len = 1;
            dp[len] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (dp[len] < nums[i]) {
                    dp[++len] = nums[i];
                } else {
                    // 在dp数组中寻找第一个大于nums[i]的数,将其更新,因为是有序,所以用二分查找
                    // 在d[1…len]中找满足d[i−1]<nums[j]<d[i] 的下标 i，
                    int l = 1, r = len, pos = 0;
                    while (l <= r) {
                        int mid = (l + r) >> 1;
                        if (dp[mid] < nums[i]) {
                            pos = mid;
                            l = mid + 1;
                        } else {
                            r = mid - 1;
                        }
                    }
                    dp[pos + 1] = nums[i];
                }
            }
            return len;
        }
}

