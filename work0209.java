package Leetcode.smart;

/**
 * @author LuCong
 * @since 2020-09-25
 **/
public class work0209 {

    public static void main(String[] args) {
        work0209 w = new work0209();

        System.out.println(w.minSubArrayLen(7, new int[]{1, 2, 3, 4, 5}));
    }

    public int minSubArrayLen(int s, int[] nums) {

        int start = 0;
        int end = 0;

        int res = Integer.MAX_VALUE;

        int sum = 0;

        while (end < nums.length) {
            sum += nums[end];
            while (sum >= s) {
                res = Math.min(res, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;

    }

}

