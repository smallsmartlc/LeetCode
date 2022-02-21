package Leetcode.smart;

/**
 * LeetCode0397 整数替换
 */
public class work0397 {
    public static void main(String[] args) {
        work0397 w = new work0397();
        System.out.println(w.integerReplacement(4));
    }

    public int integerReplacement(int n) {
        int res = 0;
        while (n > 1) {
            if ((n & 1) == 0) {
                res++;
                n >>= 1;
            } else if ((n & 3) == 3) {// 末尾是11
                if (n == 3) return res + 2;
                res += 2;
                n = (n >> 1) + 1;
            } else { // 01
                res += 2;
                n >>= 1;
            }
        }
        return res;
    }
}