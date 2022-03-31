package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;

/**
 * 0728 自除数
 */

public class work0728 {
    public static void main(String[] args) {
        work0728 w = new work0728();
        System.out.println(w.selfDividingNumbers(1, 22));
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>(right - left);
        for (int i = left; i <= right; i++) {
            if (check(i)) list.add(i);
        }
        return list;
    }

    private boolean check(int n) {
        int k = n;
        while (k > 0) {
            int digit = k % 10;
            if (digit == 0 || n % (k % 10) != 0) return false;
            k /= 10;
        }
        return true;
    }
}