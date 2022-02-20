package Leetcode.smart;

/**
 * LeetCode0396 旋转函数
 */
public class work0396 {
    public static void main(String[] args) {
        work0396 w = new work0396();
        System.out.println(w.maxRotateFunction(new int[]{4, 3, 2, 6}));
    }

    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int total = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            total += i * nums[i];
        }
        int res = total;
        for (int i = 1; i < n; i++) {
            total += sum - n * nums[n - i];
            if (total > res) res = total;
        }
        return res;
    }

}