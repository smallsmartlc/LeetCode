package Leetcode.smart;

import java.util.*;

/**
 * 0591 标签验证器
 */

public class work0591 {
    public static void main(String[] args) {
        work0591 w = new work0591();
        System.out.println(w.isValid("<DIV>This is the first line <![CDATA[<div>]]></DIV>"));
    }


    public boolean isValid(String code) {
        char[] chars = code.toCharArray();
        int n = chars.length;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < n; ) {
            if (chars[i] == '<') {
                if (i == n - 1) return false;
                if (chars[i + 1] == '/') {
                    int j = i + 2;
                    while (j < n && chars[j] != '>') j++;
                    if (j == n) return false; // 没有闭合
                    String tagName = code.substring(i + 2, j);
                    if (stack.isEmpty() || !stack.peek().equals(tagName)) return false;
                    stack.pop();
                    i = j + 1;
                    if (stack.isEmpty() && i != n) {
                        return false;
                    }
                } else if (chars[i + 1] == '!') {
                    if (stack.isEmpty()) return false;
                    if (i + 9 > n) return false;// cdata长度不够
                    String cdata = code.substring(i + 2, i + 9);
                    if (!"[CDATA[".equals(cdata)) {
                        return false;
                    }
                    int j = code.indexOf("]]>", i);
                    if (j < 0) {
                        return false;
                    }
                    i = j + 1;
                } else {
                    int j = code.indexOf('>', i);
                    if (j < 0) return false;
                    String tagName = code.substring(i + 1, j);
                    if (tagName.length() < 1 || tagName.length() > 9) return false;
                    for (int k = 0; k < tagName.length(); ++k) {
                        if (!Character.isUpperCase(tagName.charAt(k))) {
                            return false;
                        }
                    }
                    stack.push(tagName);
                    i = j + 1;
                }
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                ++i;
            }
        }
        return stack.isEmpty();
    }
}