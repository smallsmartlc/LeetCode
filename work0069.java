package Leetcode.smart;

public class work0069 {
	public static void main(String[] args) {
		work0069 w= new work0069();
		System.out.println(w.mySqrt(8));
	}
	public int mySqrt(int x) {
		if(x<1) return 0;
		if(x<4) return 1;
		int left = 0;
		int right = x/2;
		while(left<=right) {
			int mid = (left+right)/2;
			if(x/mid==mid) {
				return mid;
			}else if(x/mid>mid) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		return right;
    }
}
