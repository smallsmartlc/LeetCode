package Leetcode.smart;


public class work0191{
	public static void main(String[] args) {
		work0191 w = new work0191();
		System.out.println(w.hammingWeight(43261596));
	}
	public int hammingWeight(int n) {
		int bits = 0;
	    int mask = 1;
	    for (int i = 0; i < 32; i++) {
	        if ((n & mask) != 0) {
	            bits++;
	        }
	        mask <<= 1;
	    }
	    return bits;
    }
}