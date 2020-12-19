package Leetcode.smart;

import java.util.Arrays;

/**
 * 0258 各位相加
 */
public class work0263 {

    public static void main(String[] args) {

        work0263 w = new work0263();
        System.out.println(w.isUgly(5));
    }

    public boolean isUgly(int num) {
        if (num < 1) return false;
        while (num > 1) {
            if (num % 2 == 0) num /= 2;
            else if (num % 3 == 0) num /= 3;
            else if (num % 5 == 0) num /= 5;
            else return false;
        }
        return num == 1;
    }
}

