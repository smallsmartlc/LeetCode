package Leetcode.smart;

//LeetCode0372 超级次方

public class work0372 {
    public static void main(String[] args) {
        work0372 w = new work0372();
        System.out.println(w.superPow(2147483647, new int[]{2, 0, 0}));
    }

    static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        int res = 1;
        for (int i : b) {
//            res = ((pow(res, 10) % MOD) * (pow(a, i) % MOD)) % MOD;
            res = (int) ((long) pow(res, 10) * pow(a, i) % MOD);
        }
        return res;
    }

    private int pow(int x, int n) {
        // x次幂的余数
        int res = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
//                res = ((res % MOD) * (x % MOD)) % MOD;
                res = (int) ((long) res * x % MOD);
            }
//            x = ((x % MOD) * (x % MOD)) % MOD;
            x = (int) ((long) x * x % MOD);
            n >>= 1;
        }
        return res;
    }


}