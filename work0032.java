package Leetcode.smart;

import java.util.Stack;

public class work0032 {
	public int longestValidParentheses(String s) {
		if(s.length()<=1) return 0;
		if(isValid(s)) return s.length();
		int len = 0;
		int res = 0; 
		for (int i = 0; i < s.length()-len; i++) {
			for (int j = i+len; j <= s.length(); j+=2) {
				if(isValid(s.substring(i, j))) {
					len = Math.max(len, j - i);
				}
			}
		}
		return len;
    }
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for(char c:s.toCharArray()) {
			if(c=='(') {
				stack.push(')');
			}else if(stack.empty()||stack.pop()!=c) {
				return false;
			}
		}
		if(stack.empty()) return true;
		return false;
    }
	public static void main(String[] args) {
		work0032 w = new work0032();
		String s = ")(";
		System.out.println(w.longestValidParentheses(s));
		
	}
}
