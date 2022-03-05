package Leetcode.smart;

/**
 * LeetCode0740 删除并获得点数
 */

public class work0740 {
    public static void main(String[] args) {
        work0740 w = new work0740();
        System.out.println(w.deleteAndEarn(new int[]{3, 4, 2}));
    }

    public int deleteAndEarn(int[] nums) {
        int size = 0;
        for (int num : nums) {
            if (num > size) size = num;
        }
        int[] sum = new int[size + 1];
        for (int num : nums) {
            sum[num] += num;
        }
        int first = sum[0];
        int second = Math.max(sum[0], sum[1]); // 滚动数组
        for (int i = 2; i <= size; i++) {
            int now = Math.max(first + sum[i], second);
            first = second;
            second = now;
        }
        return second;
    }
}