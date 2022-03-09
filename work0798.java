package Leetcode.smart;

/**
 * LeetCode0798. 得分最高的最小轮调
 */

public class work0798 {
    public static void main(String[] args) {
        work0798 w = new work0798();
        System.out.println(w.bestRotation(new int[]{1, 3, 0, 2, 4}));
    }

    public int bestRotation(int[] nums) {
        int n = nums.length;
        int res = 0;
        int score = 0;
        int[] step = new int[n];// 对每个k有多少个与下标相等的数
        for (int i = 0; i < n; i++) {
            if (nums[i] <= i) {
                score++;
                step[i - nums[i]]++;
            } else step[i + n - nums[i]]++;
        }
        int maxScore = score;
        for (int k = 1; k < n; k++) {
            // nums[i] >= 0 所以 移动到首位必加分
            score = score - step[k - 1] + 1; // 上一步数组中等于下标的个数
            if (score > maxScore) {
                maxScore = score;
                res = k;
            }
        }
        return res;
    }
}