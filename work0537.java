package Leetcode.smart;

/**
 * LeetCode0537 复数乘法
 */

public class work0537 {
    public static void main(String[] args) {
        work0537 w = new work0537();
        System.out.println(w.complexNumberMultiply2("1+-1i", "1+-1i"));
    }

    public String complexNumberMultiply(String num1, String num2) {
        int[] nums = new int[4];
        String[] split = num1.split("\\+|i");
        int n1 = Integer.parseInt(split[0]);
        int i1 = Integer.valueOf(split[1]);
        split = num2.split("\\+|i");
        int n2 = Integer.parseInt(split[0]);
        int i2 = Integer.valueOf(split[1]);
        return String.format("%d+%di", n1 * n2 - i1 * i2, n1 * i2 + n2 * i1);
    }

    public String complexNumberMultiply2(String num1, String num2) {
        int[] n1 = check(num1);
        int[] n2 = check(num2);
        StringBuilder sb = new StringBuilder();
        return sb.append(n1[0] * n2[0] - n1[1] * n2[1])
                .append('+')
                .append(n1[0] * n2[1] + n1[1] * n2[0])
                .append('i').toString(); //StringBuilder是最快的
    }

    private int[] check(String n) {
        int[] nums = new int[2];
        int i = 0;
        int flag = 1;
        int num = 0;
        for (char c : n.toCharArray()) {
            if (c == '-') {
                flag = -1;
                continue;
            } else if (c < '0' || c > '9') {
                nums[i++] = flag * num;
                flag = 1;
                num = 0;
            } else num = num * 10 + c - '0';
        }
        return nums;
    }

}