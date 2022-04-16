package Leetcode.smart;

/**
 * 0479 最大回文数乘积
 */

public class work0479 {
    public static void main(String[] args) {
        work0479 w = new work0479();
        System.out.println(w.largestPalindrome(8));
    }

    /**
     * n 取值范围是1-8,直接打表
     * return new int[]{9, 987, 123, 597, 677, 1218, 877, 475}[n-1];
     *
     * @param n
     * @return
     */
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        int max = (int) Math.pow(10, n);
        for (int left = max - 1; left > max / 10; left--) { //左半
            long temp = left;
            for (int i = left; i > 0; i /= 10) { // 右半
                temp = temp * 10 + i % 10;
            }
            for (long i = max - 1; i * i >= temp; i--) { //检查是否成立
                if (temp % i == 0) return (int) (temp % 1337);
            }
        }
        return 0;
    }
}