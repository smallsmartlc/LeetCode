package Leetcode.smart;

/**
 * LeetCode0400 第 N 位数字
 */
public class work0400 {

    public static void main(String[] args) {
        work0400 w = new work0400();
        System.out.println(w.findNthDigit(10000));
        System.out.println(w.findNthDigit(100));
        System.out.println(w.findNthDigit(2147483647));
    }

    public int findNthDigit(int n) {
        int i = 1; // 位数
        long t = 9; // 小于当前位数的所有数字数,1为9,2为99,3为999
        long target = 0; // 当前位数-1的所有数字数 1为0,2为9,3为999,t-target = 9...0,位数等于i的数字数
        while (n > (t - target) * i) {
            n -= (t - target) * i; // 位数等于i的所有数字
            target = t;
            t = t * 10 + 9;
            i++;
        }
        target += n / i;
        int j = i - n % i; //从后往前数
        if (j != i) {
            target++;
            while (j-- > 0) {
                target /= 10;
            }
        }
        return (int) target % 10;
    }
}

