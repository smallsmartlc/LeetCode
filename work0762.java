package Leetcode.smart;

/**
 * 0762 二进制表示中质数个计算置位
 */

public class work0762 {
    public static void main(String[] args) {
        work0762 w = new work0762();
        System.out.println(w.countPrimeSetBits(6, 10));
    }

    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            int num = Integer.bitCount(i);
            if (isPrime(num)) ans++;
        }
        return ans;
    }

    private boolean isPrime(int n) {
//        int[] map = new int[21];// n最大到20,使用bitmap代替
        int mask = 665772; //aka 10100010100010101100; bitmap表示第i个数是否为质数
        return ((1 << n) & mask) != 0;
    }

    public static int bitCount(int i) {
        // HD, Figure 5-2 Integer内部实现
        i = i - ((i >>> 1) & 0x55555555); // 0b1010101010101010101010101010101
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }
}