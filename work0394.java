package Leetcode.smart;

import java.util.Stack;

/**
 * LeetCode0394 字符串解码
 */
public class work0394 {
    public static void main(String[] args) {
        work0394 w = new work0394();
        System.out.println(w.decodeString("3[a]2[bc]"));
        System.out.println(w.decodeString("3[a2[c]]"));
        System.out.println(w.decodeString("2[abc]3[cd]ef"));
        System.out.println(w.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

    public String decodeString(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        Stack<Integer> multiStack = new Stack<>();
        int multi = 0;
        stack.push(new StringBuilder());
        for (char c : s.toCharArray()) {
            if (isDigit(c)) {
                multi = multi * 10 + c - '0';
            }
            if (isLetter(c)) {
                stack.peek().append(c);
            }
            if (c == '[') {
                stack.push(new StringBuilder());
                multiStack.push(multi == 0 ? 1 : multi);
                multi = 0;
            }
            if (c == ']') {
                StringBuilder pop = stack.pop();
                Integer time = multiStack.pop();
                while (time > 0) {
                    stack.peek().append(pop);
                    time--;
                }
            }
        }
        return stack.peek().toString();
    }

    private boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}