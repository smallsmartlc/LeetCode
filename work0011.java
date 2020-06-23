package Leetcode.smart;

public class work0011 {
	public int maxArea(int[] height) {
		int l = 0;
		int r = height.length-1;
		int res = 0;
		while(l<=r) {
			if(Math.min(height[l],height[r])*(r-l)>res) res= Math.min(height[l],height[r])*(r-l);
			if(height[l]<height[r]) l++;
			else r--;
		}
		
		return res;
    }
	public static void main(String[] args) {
		work0011 w = new work0011();
		int[] height = new int[] {1,8,6,2,5,4,8,3,7};
		System.out.println(w.maxArea(height));
	}
}
