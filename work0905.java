package Leetcode.smart;

import java.util.Arrays;

/**
 * 0905 按奇偶排序数组
 */

public class work0905 {
    public static void main(String[] args) {
        work0905 w = new work0905();
        System.out.println(Arrays.toString(w.sortArrayByParity(new int[]{3,1,2,4})));
    }


    public int[] sortArrayByParity(int[] nums) {
        int first = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1 ) == 0) {
                swap(nums,first++,i);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }
}