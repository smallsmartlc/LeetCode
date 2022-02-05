package Leetcode.smart;

//367 有效的完全平方数

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class work0368 {

    public static void main(String[] args){
        work0368 w = new work0368();
        System.out.println(w.largestDivisibleSubset2(new int[]{1, 2, 3}));
    }

    public List<Integer> largestDivisibleSubset2(int[] nums) {
        // 优化
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] pre = new int[nums.length]; // 用pre数组记录前一个下标,优化回溯
        int max = 0;
        int maxSize = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        pre[i] = j;
                        // 更新pre数组
                    }
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                max = i;
            }
        }
        List<Integer> res = new ArrayList<>(maxSize + 1);
        res.add(nums[max]);
        while (maxSize > 0){
            res.add(nums[max = pre[max]]);
            maxSize--;
        }
        return res;
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int maxNum = 0;
        int maxSize = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxNum = nums[i];
            }
        }
        ArrayList<Integer> res = new ArrayList<>(maxSize + 1);
        if (maxSize < 1) {
            res.add(nums[0]);
            return res;
        }
        for (int i = nums.length - 1; i >= 0 && maxSize >= 0; i--) {
            if (dp[i] == maxSize && maxNum % nums[i] == 0) {
                maxSize--;
                maxNum = nums[i];
                res.add(nums[i]);
            }
        }
        return res;
    }

}