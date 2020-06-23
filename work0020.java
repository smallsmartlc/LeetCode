package Leetcode.smart;

import java.util.Stack;

public class work0020 {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for(char c:s.toCharArray()) {
			if(c=='{') {
				stack.push('}');
			}else if(c=='[') {
				stack.push(']');
			}else if(c=='(') {
				stack.push(')');
			}else if(stack.empty()||stack.pop()!=c) {
				return false;
			}
		}
		if(stack.empty()) return true;
		return false;
    }
	public static void main(String[] args) {
		work0020 w = new work0020();
		System.out.println(w.isValid("({)}[]"));
	}
}
