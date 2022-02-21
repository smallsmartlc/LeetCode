package Leetcode.smart;

import java.util.Random;

/**
 * LeetCode0398 随机数索引
 */
public class work0398 {
    public static void main(String[] args) {
        work0398 w = new work0398(new int[]{});
        System.out.println(w.pick(4));
    }

    private int[] nums;
    private Random random = new Random();

    public work0398(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int i = 1;
        int res = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == target) {
                if (random.nextInt(i++) == 0) {
                    res = j;
                }
            }
        }
        return res;
    }
}