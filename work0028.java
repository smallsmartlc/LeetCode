package Leetcode.smart;

public class work0028 {
	public int strStr(String haystack, String needle) {
		if (needle.equals("")) {
			return 0;
		}
		int len = needle.length();
		for(int i = 0;i<haystack.length()-len+1;i++) {
			if(haystack.substring(i, i+len).equals(needle)) {
				return i;
			}
		}
		return -1;
    }
	public static void main(String[] args) {
		work0028 w = new work0028();
		int[] nums = { 1, 1, 2, 2, 2, 2, 3, 4, 5 };
		System.out.println(w.strStr("a", "a"));
	}
}
