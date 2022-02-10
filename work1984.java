package Leetcode.smart;

import java.util.Arrays;

/**
 * LeetCode1984 学生分数的最小差值
 *
 * @author LuCong
 * @since 2020-10-30
 **/
public class work1984 {
    public static void main(String[] args) {
        work1984 w = new work1984();
        System.out.println(w.minimumDifference(new int[]{9,4,1,7}, 2));
    }

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        k--;
        for (int i = 0; k < nums.length; i++,k++) {
            min = Math.min(min, nums[k] - nums[i]);
        }
        return min;
    }

}







