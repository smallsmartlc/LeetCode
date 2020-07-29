package Leetcode.smart;

public class work0070 {
	public int climbStairs(int n) {
		//��̬�滮:��i��ֻ���ɵ�i-1����һ�����i-2��������
		//res[i] = res[i-1]+res[i-2];
		int dp[] = new int[n];
		dp[0]=1; 
		if(n > 1) dp[1]=2;
		for (int i = 2; i < n; i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		return dp[n-1];
	}
	public int climbStairs2(int n) {
		//��ѧ��,쳲���������
		if(n==0) return 0;
		int res = 1;
		int now = 1;
		for(int i = 1;i<n;i++) {
			res+=now;
			now = res-now;
		}
		return res;
	}
	public int climbStairs3(int n) {
		//������Ա��
		int[] a = new int[]{1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765,10946,17711,28657,46368,75025,121393,196418,317811,514229,832040,1346269,2178309,3524578,5702887,9227465,14930352,24157817,39088169,63245986,102334155,165580141,267914296,433494437,701408733,1134903170,1836311903};
		return a[n-1];
		//ʱ�临�Ӷ�o(1),��ͷ
	}
	public static void main(String[] args) {
		work0070 w= new work0070();
		System.out.println(w.climbStairs(5));
	}
}
