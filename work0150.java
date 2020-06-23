package Leetcode.smart;

import java.util.Stack;

public class work0150 {
	public static void main(String[] args) {
		 work0150 w = new work0150();
		 String[] s1 = new String[] {"2","1","+","3","*"};
		 String[] s2 = new String[] {"4","13","5","/","+"};
		 String[] s3 = new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		 
		 System.out.println(w.evalRPN(s3));
	}
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String str : tokens) {
			if(str.equals("+")) {
				stack.push(stack.pop()+stack.pop());
				continue;
			}
			if(str.equals("-")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b-a);
				continue;
			}
			if(str.equals("*")) {
				stack.push(stack.pop()*stack.pop());
				continue;
			}
			if(str.equals("/")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b/a);
				continue;
			}
			stack.push(Integer.parseInt(str));
		}
		
		return stack.pop();
    }
}