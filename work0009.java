package Leetcode.smart;

public class work0009 {
	public boolean isPalindrome(int x2) {
		if(x2<0) return false;
		int x = x2;
		int res = 0;
		while(true) {
			res = res*10 + x%10;
			x=x/10;
			if(x<=0) break;
		}
		return res==x2? true:false;
	}

	public static void main(String[] args) {
		work0009 w = new work0009();
		System.out.println(w.isPalindrome(0));

	}
}
