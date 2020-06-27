package Leetcode.smart;


public class work0171 {
	public static void main(String[] args) {
		work0171 w = new work0171();
		System.out.println(w.titleToNumber("ZY"));
	}
	public int titleToNumber(String s) {
		int res = 0;
		int n = 0;
		for (int i = s.length()-1; i >=0; i--) {
			res += (s.charAt(i)-'A'+1)*Math.pow(26, n);
			n++;
		}
		return res;
	}
}

