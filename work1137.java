package Leetcode.smart;

/**
 * LeetCode1137 第 N 个泰波那契数
 */

public class work1137 {
    public static void main(String[] args) {
        work1137 w = new work1137();
        System.out.println(w.tribonacci(25));
    }

    public int tribonacci(int n) {
        if (n < 2) return n;
        if (n == 2) return 1;
        int i = 0, j = 1, k = 1; // 滚动数组
        while (n-- >= 2) {
            k = i + j + k;
            j = k - i - j;
            i = k - j - i;
        }
        return j;
    }
}