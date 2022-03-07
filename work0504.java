package Leetcode.smart;

/**
 * 0504 七进制数
 */

public class work0504 {
    public static void main(String[] args) {
        work0504 w = new work0504();
        System.out.println(w.convertToBase7(100));
    }

    public String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuilder res = new StringBuilder();
        boolean flag = num < 0;
        if (flag) {
            num = -num;
        }
        while (num > 0) {
            res.append(num % 7);
            num /= 7;
        }
        if (flag) res.append('-');
        return res.reverse().toString();
    }
}