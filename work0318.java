package Leetcode.smart;

import java.util.Arrays;

/**
 * LeetCode0318 最大单词长度乘积
 */

public class work0318 {
    public static void main(String[] args) {
        work0318 w = new work0318();
        System.out.println(w.maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
    }

    public int maxProduct(String[] words) {
        // 位运算
        int[] code = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int len = word.length();
            for (int j = 0; j < len; j++) {
                code[i] |= 1 << word.charAt(j)-'a';
            }
        }
        // 暴力计算最大值
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if(words[i].length() * words[j].length() > max){
                    max = (code[i] & code[j]) == 0? words[i].length() * words[j].length() : max;
                }
            }
        }
        return max;
    }
}