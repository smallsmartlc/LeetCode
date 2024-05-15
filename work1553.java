package Leetcode.smart;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode1553 吃掉 N 个橘子的最少天数
 *
 * @author LuCong
 * @since 2022-3-8
 **/
public class work1553 {
    public static void main(String[] args) {
        work1553 w = new work1553();
        System.out.println(w.minDays(10));
    }

    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int minDays(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        memo.put(n, Math.min(n % 2 + 1 + minDays(n / 2), n % 3 + 1 + minDays(n / 3)));
        return memo.get(n);
    }
}





