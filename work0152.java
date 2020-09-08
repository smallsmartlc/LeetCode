package Leetcode.smart;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class work0152 {
	public static void main(String[] args) {
		 work0152 w = new work0152();
		 int[] nums = new int[] {2,3,-2,4};
		 System.out.println(w.maxProduct(nums));
	}
	public int maxProduct(int[] nums) {
		int res = Integer.MIN_VALUE;
		int imax = 1 , imin = 1;
		for(int i=0; i<nums.length; i++){
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);
            
            res = Math.max(res, imax);
        }
		return res;
    }
}