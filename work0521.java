package Leetcode.smart;

/**
 * LeetCode0521 最长特殊序列 Ⅰ
 */

public class work0521 {
    public static void main(String[] args) {
        work0521 w = new work0521();
        System.out.println(w.findLUSlength("aba","cdc"));
    }
    public int findLUSlength(String a, String b) {
        return a.equals(b)?-1:Math.max(a.length(),b.length());
    }
}