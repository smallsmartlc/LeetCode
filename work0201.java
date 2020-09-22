package Leetcode.smart;


public class work0201 {
    public static void main(String[] args) {
        work0201 w = new work0201();
        System.out.println(w.rangeBitwiseAnd(5, 7));
    }

    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        // 找到公共前缀
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }
}