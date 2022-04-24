package Leetcode.smart;

/**
 * 0868 推多米诺
 */

public class work0868 {
    public static void main(String[] args) {
        work0868 w = new work0868();
        System.out.println(w.binaryGap(22));
    }

    public int binaryGap(int n) {
        int pre = -1;
        int res = 0;
        for (int i = 0; n > 0; i++, n >>= 1) {
            if ((n & 1) == 1) {
                if (pre != -1) {
                    res = Math.max(res, i - pre);
                }
                pre = i;
            }
        }
        return res;
    }
}