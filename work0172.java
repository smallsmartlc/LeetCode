package Leetcode.smart;


public class work0172 {
	public static void main(String[] args) {
		work0172 w = new work0172();
		System.out.println(w.trailingZeroes(30));
	}
    public int trailingZeroes(int n) {
    	return n==0?0:n/5+trailingZeroes(n/5);
    }
}

