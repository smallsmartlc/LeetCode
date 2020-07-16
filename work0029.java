package Leetcode.smart;

public class work0029 {
	public int divide(int dividend, int divisor) {
		int i = -1;
		int a = Math.abs(dividend);
		int b = Math.abs(divisor);
		if (a>=0) {
			while(a>=0) {
				a-=b;
				i++;
			}
		}else {
			while(a<=0) {
				a+=b;
				i++;
			}
		}
		int m = 1;
		if(dividend<0||divisor<0) m=-1;
		if(dividend<0&&divisor<0) m=1;
		return m*i;
    }
	public static void main(String[] args) {
		work0029 w = new work0029();
		System.out.println(w.divide(-2147483648, 1));
	}
}
