package Leetcode.smart;

/**
 * 0713 乘积小于 K 的子数组
 */

public class work0713 {
    public static void main(String[] args) {
        work0713 w = new work0713();
        System.out.println(w.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i = 0;
        int ans = 0;
        int prod = 1;
        for (int j = 0; j < nums.length; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            ans += j - i + 1;
        }
        return ans;
    }
}