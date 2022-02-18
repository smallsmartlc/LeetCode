package Leetcode.smart;

import java.util.Stack;

/**
 * LeetCode0388 文件的最长绝对路径
 */
public class work0388 {
    public static void main(String[] args) {
        work0388 w = new work0388();
        System.out.println(w.lengthLongestPath("dir\n        file.txt"));
    }

    public int lengthLongestPath(String input) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (String s : input.split("\n")) {
            int level = getLevel(s);
            while (level < stack.size()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(s.length());
            } else {
                stack.push(stack.peek() + 1 + s.length() - level);
            }
            if (s.indexOf('.') != -1) {
                res = Math.max(res, stack.pop());
            }
        }
        return res;
    }

    private int getLevel(String str) {
        return str.lastIndexOf('\t') + 1;
    }
}