package Leetcode.smart;

import java.util.Stack;

/**
 * LeetCode0389 找不同
 */
public class work0389 {
    public static void main(String[] args) {
        work0389 w = new work0389();
        System.out.println(w.findTheDifference("abcd", "abcde"));
    }

    public char findTheDifference(String s, String t) {
        char c = 0;
        for (char c1 : (s + t).toCharArray()) {
            c ^= c1;
        }
        return c;
    }
}