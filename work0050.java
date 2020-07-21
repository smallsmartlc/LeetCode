package Leetcode.smart;

public class work0050 {
	public double myPow(double x, int n) {
		//递归 通过
		if(n==-1) return 1/x;
		if(n==0) return 1;
		if(n==1) return x;
		double t = myPow(x,n/2);
		return n%2==0?t*t:n>0?t*t*x:t*t/x;
	}
	public double myPow3(double x, int n) {
		//递归,超时
		if(n==-1) return 1/x;
		if(n==0) return 1;
		if(n==1) return x;
		return myPow3(x,n/2)*myPow3(x,n-n/2);
	}
	public double myPow2(double x, int n) {
		//超时
		if(n == 0) return 1;
		if(n<0) {
			n = -n;
			x = 1/x;
		}
		double res =1;
		for(int i = 0;i<n;i++) {
			res*=x;
		}
		return res;
    }
	public static void main(String[] args) {
		work0050 w = new work0050();
		Map<Character[], Integer> res = new HashMap<>();
		System.out.println(w.myPow(34.00515,-3));
	}
}
