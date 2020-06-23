package Leetcode.smart;


public class work0005 {
	public String longestPalindrome(String s) {
		if(s.equals("")) return s;
		int len=0;
		int sidx = -1;
		for(int i=0;i<s.length();i++) {
			for(int j=i+len;j<s.length();j++) {
				if(isRe(s, i, j)) {
					len = j-i;
					sidx = i;
				}
			}
			if(i+len>s.length()) break;
		}
		s = s.substring(sidx, sidx+len+1);
		return s;
    }
	public boolean isRe(String s,int i,int j) {
		while(true) {
			if(s.charAt(i)!=s.charAt(j)) return false;
			if(j-i<=1) {
				return true;
			}
			i++;j--;
		}
	}
	public static void main(String[] args) {
		String s = "aaabaaaa";
		work0005 w = new work0005();
		System.out.println(w.longestPalindrome(s));
	}
}



