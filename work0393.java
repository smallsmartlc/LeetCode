package Leetcode.smart;

/**
 * LeetCode0392 判断子序列
 */
public class work0393 {
    public static void main(String[] args) {
        work0393 w = new work0393();
        System.out.println(w.validUtf8(new int[]{197, 130, 1}));
        System.out.println(w.validUtf8(new int[]{235, 140, 4}));
        System.out.println(w.validUtf8(new int[]{250,145,145,145,145}));
    }

    public boolean validUtf8(int[] data) {
        int n = data.length;
        for (int i = 0; i < n; i++) {
            if ((data[i] & 128) == 0) {
                continue;
            }
            int p = 0; // 当前字节的长度
            while ((data[i] & 128) > 0) {
                p++;
                data[i] <<= 1;
            }
            if(p == 1) return false;
            while (--p > 0) {
                if (++i > n - 1) return false;
                if ((data[i] & 128) == 0
                        || (data[i] & 64) > 0) return false;
            }
        }
        return true;
    }

}