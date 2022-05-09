package Leetcode.smart;

import java.util.Arrays;

/**
 * 0942 增减字符串匹配
 */

public class work0942 {
    public static void main(String[] args) {
        work0942 w = new work0942();
        System.out.println(Arrays.toString(w.diStringMatch("DDI")));
    }

    public int[] diStringMatch(String s) {
        int n = s.length();
        int l = 0, r = n;
        int[] res = new int[n + 1];
        for (int i = 0; i < n; i++) {
            res[i] = s.charAt(i) == 'I' ? l++ : r--;
        }
        res[n] = l; // l此时等于r,是剩下的一个数
        return res;
    }

}