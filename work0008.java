package Leetcode.smart;

//2^31-1=2147483647,-2^31=-2147483648
public class work0008 {
	//注意边界条件
	public int myAtoi(String str) {
		if (str.length() == 0)
			return 0;
		int i = 0;
		boolean flag = true;
		int res = 0;
		while (str.charAt(i) == ' ') {
			i++;
			if (i >= str.length()) return 0;
		}
		if (i >= str.length()) return 0;
		if (str.charAt(i) == '-') {
			flag = false;
			i++;
		} else if (str.charAt(i) == '+') {
			i++;
		}
		if (i >= str.length()) return 0;
		while ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
			int pop = str.charAt(i) - 48;
			if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7))	return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8)) return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			res = res * 10 + pop;
			i++;
			if (i >= str.length()) break;
		}
		return flag ? res : -res;
	}

	public static void main(String[] args) {
		work0008 w = new work0008();
		System.out.println(w.myAtoi(" "));

	}
}
