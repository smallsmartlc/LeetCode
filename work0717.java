package Leetcode.smart;

/**
 * LeetCode0717 1比特与2比特字符
 */

public class work0717 {
    public static void main(String[] args) {
        work0717 w = new work0717();
        System.out.println(w.isOneBitCharacter(new int[]{0, 1, 0}));
        System.out.println(w.isOneBitCharacter2(new int[]{1, 1, 1, 0}));
    }

    public boolean isOneBitCharacter2(int[] bits) {
        int n = bits.length, i;
        for (i = n - 2; i >= 0 && bits[i] == 1; i--) ; // 0 一定是一个数的结尾,找上一个0,没有就为-1
        return (n - 2 - i & 1) == 0; // 1的数量,是偶数就自己解决,是奇数说明需要一个0来结尾
    }

    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        for (int i = 0; i < n - 1; i++) {
            if (bits[i] == 1 && ++i == n - 1) return false;
        }
        return true;
    }

}