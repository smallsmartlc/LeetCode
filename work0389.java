package Leetcode.smart;

/**
 * LeetCode0389 找不同
 */
public class work0389 {
    public static void main(String[] args) {
        work0389 w = new work0389();
        System.out.println(w.findTheDifference("abcd", "abcde"));
    }

    public char findTheDifference2(String s, String t) {
        int ret = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) { // 两种遍历方式
            ret ^= s.charAt(i);
            ret ^= t.charAt(i);
        }
        return (char) (ret ^ t.charAt(n));
    }
    public char findTheDifference(String s, String t) {
        int c = 0;
        for (char c1 : (s + t).toCharArray()) {
            c ^= c1;
        }
        return (char) c;
    }
}