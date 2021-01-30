package Leetcode.smart;

import java.util.*;

/**
 * 0283. 移动零
 */
public class work0283 {

    public static void main(String[] args) {

        work0283 w = new work0283();
        int[] nums = new int[]{0,1,0,3,12};
        LecoUtil.LecoPrint(nums);
        w.moveZeroes(nums);
        LecoUtil.LecoPrint(nums);
    }

    public void moveZeroes(int[] nums) {
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                int temp = nums[end];
                nums[end] = nums[i];
                nums[i] = temp;
                end++;
            }
        }
    }

}

