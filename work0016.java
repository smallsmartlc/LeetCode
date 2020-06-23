package Leetcode.smart;

import java.util.Arrays;

public class work0016 {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		int res = 0;
		int flag = Integer.MAX_VALUE;
		if (nums == null || nums.length <= 2) {
			return 0;
		}
			for (int i = 0; i < nums.length; i++) {
				int l = i+1;
				int r = nums.length-1;
				while(l<r) {
					int sum = nums[i]+nums[l]+nums[r];
//					System.out.println("nums["+i+"]="+nums[i]+",nums[l]="+nums[l]+",nums[r]="+nums[r]+",i="+i+",l="+l+",r="+r);
					int now = sum-target;
//					System.out.println(now);
//					System.out.println("res="+res);
					if(now == 0) return sum;
//					System.out.println(Math.abs(now)<flag);
					if(Math.abs(now)<flag) {
						flag = Math.abs(now);
//						System.out.println("nums["+i+"]="+nums[i]+",nums[l]="+nums[l]+",nums[r]="+nums[r]+",i="+i+",l="+l+",r="+r);
//						System.out.println("flag="+flag);
						res = sum;
						if(now<0) { l++ ;}
						if(now>0) {r--;}
					}else if(now<0) { l++ ;}
					else if(now>0) {r--;}
				}
			}
		
		return res;
	}
	public static void main(String[] args) {
		work0016 w = new work0016();
		int[] nums = {1,-1,-1,0};
		int[] nums2 = {13,2,0,-14,-20,19,8,-5,-13,-3,20,15,20,5,13,14,-17,-7,12,-6,0,20,-19,-1,-15,-2,8,-2,-9,13,0,-3,-18,-9,-9,-19,17,-14,-19,-4,-16,2,0,9,5,-7,-4,20,18,9,0,12,-1,10,-17,-11,16,-13,-14,-3,0,2,-18,2,8,20,-15,3,-13,-12,-2,-19,11,11,-10,1,1,-10,-2,12,0,17,-19,-7,8,-19,-17,5,-5,-10,8,0,-12,4,19,2,0,12,14,-9,15,7,0,-16,-5,16,-12,0,2,-16,14,18,12,13,5,0,5,6};
		System.out.println(w.threeSumClosest(nums2,-59));
	}
}
