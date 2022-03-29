package Leetcode.smart;

/**
 * LeetCode0440 字典序的第K小数字
 */

public class work0440 {
    public static void main(String[] args) {
        work0440 w = new work0440();
        System.out.println(w.findKthNumber(10000, 10000));
    }

    public int findKthNumber(int n, int k) {
        int first = 1;
        while (k > 1) {
            int num = count(n, first);
            if (num < k) {
                k -= num;
                first++;
            } else {
                first *= 10;// 进入下一层
                k--;
            }
        }
        return first;
    }

    private int count(int n, long first) {
        if (first > n) return 0;
        int num = 1;
        long n1 = first * 10; // 下一层的第一个值
        long n2 = first * 10 + 9; // 下一层的最后一个值
        while (n1 <= n) {
            num += Math.min(n2, n) - n1 + 1;
            n1 = n1 * 10;
            n2 = n2 * 10 + 9;
        }
        return num;
    }

}