package Leetcode.smart;

import java.util.Stack;

public class work0071 {
	public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String str : paths) {
        	if(str.equals(""))continue;
			if(str.equals(".")) continue;
			if(str.equals("..")) {
				if(!stack.empty()) {
					stack.pop();
				}
				continue;
			}
			stack.push(str);
		}
        if(stack.empty()) return "/";
        StringBuilder res = new StringBuilder();
        while (!stack.empty()) {
        	res.insert(0, "/"+stack.pop());
		}
        return res.toString();
    }
	public static void main(String[] args) {
		work0071 w= new work0071();
		System.out.println(w.simplifyPath("/a//b////c/d//././/.."));
	}
}
