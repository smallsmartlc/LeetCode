package Leetcode.smart;

/**
 * 0908 最小差值 I
 */

public class work0908 {
    public static void main(String[] args) {
        work0908 w = new work0908();
        System.out.println(w.smallestRangeI(new int[]{3, 1, 2, 4}, 1));
    }

    public int smallestRangeI(int[] nums, int k) {
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        return Math.max(0, max - min - k * 2);
    }

}