package Leetcode.smart;


public class work0005 {
	public String longestPalindrome1(String s) {
		//动态规划
		int len = s.length();
		if(len<2) return s;
		int maxlen = 1;
		int begin = 0;
		char[] chs = s.toCharArray();
		boolean[][] dp = new boolean[len][len];
		for (int i = 0; i < len; i++) {
			dp[i][i] = true;
		}
		for (int j = 0; j < len; j++) {
			for (int i = 0; i < j; i++) {
				if (chs[i]!=chs[j]) {
					dp[i][j] = false;
				}else {
					if(j-i<3) {
						dp[i][j] = true;
					}else {
						dp[i][j] = dp[i+1][j-1];
					}
				}
				if(dp[i][j] && j-i+1 > maxlen) {
					maxlen = j-i+1;
					begin = i;
				}
			}
		}
		return s.substring(begin,begin+maxlen);
	}
	public String longestPalindrome(String s) {
		//暴力法
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
		System.out.println(w.longestPalindrome1(s));
	}
}



