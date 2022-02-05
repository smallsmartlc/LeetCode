package Leetcode.smart;

//371. 两整数之和

public class work0371 {
    public static void main(String[] args) {
        work0371 w = new work0371();
        System.out.println(w.getProduct(-25, 25));
    }

    public int getSum(int a, int b) {
        for (int t; (t = a & b) != 0; ) {
            a ^= b;
            b = t << 1;
        }
        return a ^ b;
    }

    public int getSum2(int a, int b) {
        int t = a & b;
        a = a ^ b;
        if (t != 0) return getSum2(a, t << 1);
        return a;
    }

    public int getProduct(int a, int b) {
        int res = 0;
        for (int i = 0; a > 0; i++, a >>= 1) {
            if ((a & 1) == 0) continue;
            res = getSum(b << i, res);
        }
        return res;
    }
}