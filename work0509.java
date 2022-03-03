package Leetcode.smart;

/**
 * LeetCode0509 斐波那契数
 */

public class work0509 {
    public static void main(String[] args) {
        work0509 w = new work0509();
        System.out.println(w.fib(2));
    }

    public int fib(int n) {
        if (n < 2) return n;
        int i = 0, j = 1; // 滚动数组
        while (n-- >= 2) {
            j = i + j;
            i = j - i;
        }
        return j;
    }
}