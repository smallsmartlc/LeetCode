package Leetcode.smart;

import java.util.Stack;

public class work0020 {
	public boolean isValid(String s) {
		char[] ch = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (char c : ch) {
			if(c=='{') stack.push('}');
			else if(c=='[') stack.push(']');
			else if(c=='(') stack.push(')');
			else if(stack.isEmpty()||stack.pop()!=c) return false;
		}
		return stack.isEmpty();
    }
	public static void main(String[] args) {
		work0020 w = new work0020();
		System.out.println(w.isValid("({)}[]"));
	}
}
