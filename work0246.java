package Leetcode.smart;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * LeetCode0246	中心对称数 (会员)
 * LintCode0644 镜像数字
 */
public class work0246 {
    public static void main(String[] args) {
        work0246 w = new work0246();
        System.out.println(w.isStrobogrammatic("68"));
    }

    public boolean isStrobogrammatic(String num) {
        // write your code here
        int[] map = new int[10];
        Arrays.fill(map, -1);
        map[0] = 0;
        map[1] = 1;
        map[6] = 9;
        map[9] = 6;
        map[8] = 8;
        char[] chars = num.toCharArray();
        int left = 0, right = chars.length-1;
        while (left <= right) {
            if (map[chars[left] - '0'] != chars[right] - '0') return false;
            left++;
            right--;
        }
        return true;
    }
}
