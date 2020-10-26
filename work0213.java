package Leetcode.smart;


import java.util.ArrayList;
import java.util.List;

public class work0213 {
    public static void main(String[] args) {
        work0213 w = new work0213();
        int[] nums = new int[]{1, 2, 3, 1};

        System.out.println(w.rob(nums));


    }


    public int rob(int[] nums) {
        //因为首尾相连,所以首尾两个房间只有三种情况
        // 首尾都不被偷(房间非负,所以不考虑,偷哪个房间都钱数都会增加),第一个房间被偷,第二个房间被偷
        //所以此题可以转化为考虑情况二和情况三钱数的大小
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        return Math.max(robLen(nums, 0, nums.length - 1), robLen(nums, 1, nums.length));

    }

    private int robLen(int[] nums, int start, int end) {
        int dp1 = 0;
        int dp2 = 0;
        for (int i = start; i < end; i++) {
            int temp = Math.max(dp2, dp1 + nums[i]);
            dp1 = dp2;
            dp2 = temp;
        }
        return dp2;
    }

}