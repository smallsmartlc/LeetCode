package Leetcode.smart;

import java.util.LinkedList;
import java.util.List;

public class work0006 {
	public String convert2(String str, int n) {
		if (n == 1) return str;
		int k = (int)Math.ceil(str.length()/(double)(2*n-2));
		StringBuilder res = new StringBuilder();
		char[] c = str.toCharArray();
		for(int i=0 ;i<n;i++) {
			for(int j = 0;j<k;j++) {
				if((i+j*(2*n-2))<c.length) {
					res.append(c[i+j*(2*n-2)]);
					
				}
				if(i!=0&&i!=n-1) {
					if(((2*n-2-i)+j*(2*n-2))<c.length) {
						res.append(c[(2*n-2-i)+j*(2*n-2)]);
					}
				}
			}
		}
		return res.toString();
    }
	public String convert(String str, int n) {
		if (n == 1) return str;
		List<StringBuilder> list = new LinkedList<>();
		for(int i=0;i<Math.min(n, str.length());i++) {
			list.add(new StringBuilder());
		}
		int curRow = 0;
		boolean down = true;
		for(char c:str.toCharArray()) {
			list.get(curRow).append(c);
			if(curRow==0||curRow==n-1) down=!down;
			curRow+=down?-1:1;
		}
		StringBuilder res = new StringBuilder();
		for(StringBuilder s :list) res.append(s);
		return res.toString();
	}
	public String convertLongTime(String str, int n) {
		//³¬Ê±
		if (n == 1) return str;
		int k = (int)Math.ceil(str.length()/(double)(2*n-2));
		String res = "";
		for(int i=0 ;i<n;i++) {
			for(int j = 0;j<k;j++) {
				if((i+j*(2*n-2))<str.length()) {
					res+=str.charAt(i+j*(2*n-2));
				}
				for(int q1=0;q1<n-2-i;q1++) {
					res+=" ";
				}
				if(i!=0&&i!=n-1) {
					if(((2*n-2-i)+j*(2*n-2))<str.length()) {
						res+=str.charAt((2*n-2-i)+j*(2*n-2));
					}
				}
				for(int q1=0;q1<3-n+i;q1++) {
					res+=" ";
				}		
			}
			res+="\n";
		}
		
		return res;

    }
	public static void main(String[] args) {
		String s = "LEETCODEISHIRING";
		work0006 w = new work0006();
		System.out.println(w.convertLongTime(s, 4));
	}
}



