package Leetcode.smart;

public class work0011 {
	public static void main(String[] args) {
		work0011 w = new work0011();
		int[] height = new int[] {1,8,6,2,5,4,8,3,7};
		System.out.println(w.maxArea(height));
	}
	public int maxArea(int[] height) {
		//Ë«Ö¸Õë
		int l = 0;
		int r = height.length-1;
		int res = 0;
		while(l<r) {
			int area = Math.min(height[l], height[r])*(r-l);
			if(area > res) res = area;
			if(height[l]<height[r]) l++;
			else r--;
		}
		return res;
    }
}
