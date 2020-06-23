package Leetcode.smart;

import java.util.Set;
import java.util.HashSet;

public class work0003 {
	public int lengthOfLongestSubstring(String s) {
		int len = 0;
		for(int i = 0 ;i<s.length();i++) {
			for (int j = i+len; j < s.length()+1; j++) {
				if(isRep(s, i, j)) {
					len =Math.max(len,j-i) ;
				}else {
					j=s.length()+1;
				}
			}
			if((i+len)>=s.length()) break;
		}
		return len;
    }
	public boolean isRep(String s,int start,int end) {
//		System.out.println(s.charAt(start)+"---"+start+"---"+end);
		Set<Character> set = new HashSet<>();
		for(int i = start;i<end;i++) {
			char c = s.charAt(i);
			if (set.contains(c)) {
				return false;
			}
			set.add(c);
		}
		return true;
	}
	public static void main(String[] args) {
		String s = "aaaaabdsdvsdfv";
		work0003 w = new work0003();
		System.out.println(w.lengthOfLongestSubstring(s));
	}
}



