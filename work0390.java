package Leetcode.smart;

/**
 * LeetCode0390 消除游戏
 */
public class work0390 {
    public static void main(String[] args) {
        work0390 w = new work0390();
        System.out.println(w.lastRemaining(9));
    }

    public int lastRemaining(int n) {
        int a1 = 1;
        int k = 0; // 次数
        int d = 1; // 公差
        int l = n; // 项数
        while (l > 1) {
            if ((k & 1) == 0 || (l & 1) == 1) { // 正向 或 反向项数为奇数
                a1 += d;
            }
            l >>= 1;//项数减半
            d <<= 1;//公差翻倍
            k++;
        }
        return a1;
    }
}