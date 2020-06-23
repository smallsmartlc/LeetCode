package Leetcode.smart;

public class work0070 {
	public int climbStairs(int n) {
		//动态规划:第i阶只能由第i-1阶跳一步或第i-2阶跳两步
		//res[i] = res[i-1]+res[i-2];
		if(n==0) return 0;
		if(n==1) return 1;
		int res[] = new int[n];
		res[0]=1; 
		res[1]=2;
		for (int i = 2; i < n; i++) {
			res[i] = res[i-1]+res[i-2];
		}
		return res[n-1];
	}
	public int climbStairs2(int n) {
		//数学法,斐波那契数列
		if(n==0) return 0;
		int res = 1;
		int now = 1;
		for(int i = 1;i<n;i++) {
			res+=now;
			now = res-now;
		}
		return res;
	}
	public static void main(String[] args) {
		work0070 w= new work0070();
		System.out.println(w.climbStairs(5));
	}
}
