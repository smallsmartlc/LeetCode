package Leetcode.smart;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode0186 翻转字符串里的单词 II (会员)
 * LintCode0927 翻转字符串II
 */

public class work0186 {
    public static void main(String[] args) {
        work0186 w = new work0186();
        LecoUtil.LecoPrint(w.reverseWords("the sky is blue".toCharArray()));
    }

    public char[] reverseWords(char[] str) {
        // write your code here
        int left = 0;
        int len = str.length;
        for (int i = 0; i < len; i++) {
            if (str[i] == ' ') {
                reverse(str, left, i - 1);
                left = i + 1;
            }
        }
        reverse(str, left, len - 1);
        reverse(str, 0, len - 1);
        return str;
    }

    private void reverse(char[] str, int left, int right) {
        while (left < right) {
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
    }
}
