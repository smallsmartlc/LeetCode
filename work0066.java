package Leetcode.smart;


public class work0066 {
	public int[] plusOne(int[] digits) {
		digits[digits.length-1]++;
		for (int i = digits.length-1; i > 0 && digits[i]==10; i--) {
			digits[i]=0;
			digits[i-1]++;
		}
		if(digits[0]==10) {
			int[] res = new int[digits.length+1];
			digits[0] = 0;
			System.arraycopy(digits, 0, res, 1, digits.length);
			res[0]=1;
			digits = res;
		}
		return digits;
    }
	public static void main(String[] args) {
		work0066 w= new work0066();
		int[] nums = new int[] {9,9,9,9};
		LecoUtil.LecoPrint(w.plusOne(nums));
	}
}
