package Leetcode.smart;

//357 计算各个位数不同的数字个数

import java.util.*;

public class work0357 {
    public static void main(String[] args) {
        work0357 w = new work0357();
        System.out.println(w.countNumbersWithUniqueDigits(3));
    }


    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        if(n == 1) return 10;
        int pre = 10;
        int temp = 9; // 9*9*8*7...
        for (int i = 2; i <= n; i++) {
            temp *= (11-i);
            pre += temp;
        }
        return pre;
    }
}