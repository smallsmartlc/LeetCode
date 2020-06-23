package Leetcode.smart;



public class work0004 {
	public double findMedianSortedArrays(int[] a, int[] b) {
		return 0;
	}
	public double findMedianSortedArraysfalse(int[] nums1, int[] nums2) {
		int m=nums1.length;
		int n = nums2.length;
		int ai = 0,bi=0;
		int[] ks = new int[m+n]; 
		for(int i=0;i<ks.length;i++) {
			if(ai>=m) {
				ks[i]=nums2[bi];
				bi++;
				continue;
			}
			if(bi>=n) {
				ks[i]=nums1[ai];
				ai++;
				continue;
			}
			if(nums1[ai]>nums2[bi]) {
				ks[i]=nums2[bi];
				bi++;
			}else{
				ks[i]=nums1[ai];
				ai++;
			}
		}
		double res = (ks[(ks.length-1)/2]+ks[ks.length/2])/2.0;
		return res;

	}
	public static void main(String[] args) {
		int[] a = {1,4,5,8,12};
		int[] b = {0,6,6,16,20};
		work0004 w = new work0004();
//		System.out.println(w.findMedianSortedArrays(a, b));
	}
}



