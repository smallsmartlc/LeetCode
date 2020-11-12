package Leetcode.smart;

import java.util.Stack;

/**
 * 226. 翻转二叉树
 */
public class work0227 {

    public static void main(String[] args) {

        work0227 w = new work0227();
        System.out.println(w.calculate(" 3/2"));
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.trim().toCharArray();
        int num = 0;
        char o = '+';
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                if(i != chars.length-1) continue;
            }
            if (o == '+') {
                stack.push(num);
            }
            if (o == '-') {
                stack.push(-num);
            }
            if (o == '*') {
                stack.push(num * stack.pop());
            }
            if (o == '/') {
                stack.push(stack.pop() / num);
            }
            o = c;
            num = 0;
        }

        int res = stack.stream().mapToInt(e -> e).sum();

        return res;
    }
}

