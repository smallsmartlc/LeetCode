package Leetcode.smart;

import java.util.Stack;

public class work0038 {
	public static void main(String[] args) {
		work0038 w = new work0038();
		System.out.println(w.countAndSay(3));
	}
	public String countAndSay(int n) {
		if(n==1) return "1";
		String res = "1";
		Stack<Character> s  = new Stack<>(); 
		for (int i = 0; i < n-1; i++) {
			String now = "";
			for(int j = 0;j<res.length();j++) {
				char c = res.charAt(j);
				if(s.isEmpty()||s.peek()==c) {
					s.push(c);
				}else{
					now+= ""+s.size()+s.pop();
					s = new Stack<>();
					s.push(c);
				}
			}
			if(!s.isEmpty()) {
				now+= ""+s.size()+s.pop();
				s = new Stack<>();
			}
			res = now;
		}
		return res;
	}
}
