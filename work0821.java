package Leetcode.smart;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 0821 字符的最短距离
 */

public class work0821 {
    public static void main(String[] args) {
        work0821 w = new work0821();
        LecoUtil.LecoPrint(w.shortestToChar("loveleetcode", 'e'));
    }

    public int[] shortestToChar(String s, char c) {
        // 两次遍历
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] res = new int[n];
        Arrays.fill(res, n);
        int pre = -1; // 前一个c出现的位置
        for (int i = 0; i < n; i++) {
            if (chars[i] == c) {
                res[i] = 0;
                pre = i;
                continue;
            }
            if (pre == -1) continue;
            res[i] = i - pre;
        }
        for (int i = pre - 1; i >= 0; i--) {
            if (chars[i] == c) {
                pre = i;
                continue;
            }
            res[i] = Math.min(res[i], pre - i);
        }
        return res;
    }
}