package Leetcode.smart;


public class work0168 {
	public static void main(String[] args) {
		work0168 w = new work0168();
		System.out.println(w.convertToTitle(701));
	}
	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while(n>26) {
			n--;
			sb.insert(0, (char)('A'+n%26));
			n /= 26;
		}
		sb.insert(0,(char)('A'+(n-1)%26));
		return sb.toString();
    }
}

