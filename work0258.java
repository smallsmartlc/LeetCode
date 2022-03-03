package Leetcode.smart;

/**
 * 0258 各位相加
 */
public class work0258 {

    public static void main(String[] args) {

        work0258 w = new work0258();
        System.out.println(w.addDigits(2342));
    }

    public int addDigits0(int num) { // 模拟
        while (num >= 10) {
            num = num / 10 + num % 10;
        }
        return num;
    }

    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }


}

