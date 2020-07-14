package Leetcode.smart;

public class work0028 {
	public static void main(String[] args) {
		work0028 w = new work0028();
		System.out.println(w.strStr2("a", "a"));
	}
	public int strStr2(String haystack, String needle) {
		int length = haystack.length();
		int len = needle.length();
		if(len==0) return 0;
		for (int start = 0; start+len <= length; start++) {
			if(haystack.substring(start, start+len).equals(needle)) return start;
		}
		return -1;
	}
}
