package Leetcode.smart;

import java.util.Stack;

public class work0032 {

    public static void main(String[] args) {
        work0032 w = new work0032();
        String s = "(()())";
        System.out.println(w.longestValidParentheses(s));

    }

    public int longestValidParentheses(String s) {
        // 动态规划
        char[] chars = s.toCharArray();
        int n = chars.length;
        if (n < 2) return 0;
        int[] dp = new int[n];
        int max = 0;
        if (chars[0] == '(' && chars[1] == ')') {
            dp[1] = 2;
            max = 2;
        }
        for (int i = 2; i < n; i++) {
            if (chars[i] == ')') {
                if (chars[i - 1] == '(') {
                    dp[i] = dp[i - 2] + 2;
                } else if (i - 1 - dp[i - 1] > -1 && chars[i - 1 - dp[i - 1]] == '('){
                    dp[i] = dp[i - 1] + (i -2-dp[i-1] > -1?dp[i-2-dp[i-1]]:0) + 2;
                }
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }

    public int longestValidParentheses1(String s) {
        // 栈
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int start = -1; // 记录一个开始入栈之前的值
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                // 将左括号的下标放入栈中
                stack.push(i);
            } else {
                // 右括号
                if (stack.isEmpty()) {
                    // 无法匹配,记录一个初始值
                    start = i;
                } else {
                    stack.pop(); //匹配
                    if (stack.empty()) {
                        // 栈里为空,用初始值获得字符串长度
                        max = Math.max(max, i - start);
                    } else {
                        // 栈里不为空,用栈顶的左括号下标来获得字符串长度
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }
        return max;
    }

    public int longestValidParentheses0(String s) {
        // 暴力法,太丢人了
        if (s.length() <= 1) return 0;
        if (isValid(s)) return s.length();
        int len = 0;
        int res = 0;
        for (int i = 0; i < s.length() - len; i++) {
            for (int j = i + len; j <= s.length(); j += 2) {
                if (isValid(s.substring(i, j))) {
                    len = Math.max(len, j - i);
                }
            }
        }
        return len;
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (stack.empty() || stack.pop() != c) {
                return false;
            }
        }
        if (stack.empty()) return true;
        return false;
    }

}
