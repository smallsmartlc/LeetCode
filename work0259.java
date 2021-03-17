package Leetcode.smart;

import java.util.Arrays;

/**
 * leetcode0259 较小的三数之和
 * lintcode918. 三数之和小于
 */
public class work0259 {

    public static void main(String[] args) {

        work0259 w = new work0259();
        System.out.println(w.threeSumSmaller(new int[]{-2,0,1,3},2));
    }

    public int threeSumSmaller(int[] nums, int target) {
        // Write your code here
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int j = i+1;
            int k = n-1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < target){
                    res+= k-j;
                    j++;
                }else{
                    k--;
                }
            }
        }
        return res;
    }

}

