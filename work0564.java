package Leetcode.smart;

/**
 * LeetCode0564 寻找最近的回文数
 */

public class work0564 {
    public static void main(String[] args) {
        work0564 w = new work0564();
        System.out.println(w.nearestPalindromic("123"));
    }

    public String nearestPalindromic(String n) {
        final int len = n.length();
        long num = Long.parseLong(n);
        long res = (long) Math.pow(10, len - 1) - 1; // 999...999
        long t = (long) Math.pow(10, len) + 1; // 100..001
        if (t != num && Math.abs(res - num) > Math.abs(t - num)) {
            res = t;
        }
        long pre = num / (long) Math.pow(10, len >> 1);//前半截
        for (int i = -1; i < 2; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(pre + i);
            StringBuilder reverse = new StringBuilder(sb).reverse();
            if (len % 2 != 0) reverse.deleteCharAt(0);
            sb.append(reverse);
            t = Long.parseLong(sb.toString());
            if (t != num && Math.abs(res - num) > Math.abs(t - num)) {
                res = t;
            }
        }
        return String.valueOf(res);
    }

}