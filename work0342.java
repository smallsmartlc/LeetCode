package Leetcode.smart;

//0344. 反转字符串

public class work0342 {
    public static void main(String[] args) {
        work0342 w = new work0342();
        int i = 1431655765;// 0b01010101010101010101010101010101; 0x55555555
        System.out.println(w.isPowerOfFour(4));
    }

    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 1431655765) != 0;
    }

    public boolean isPowerOfFour2(int n) {
        // 如果为4的幂,表示成(3+1)^x,表示为3n+1
        // 如果为2的幂,表示成(3+1)^x * 2 ,表示为3n+2;
        return n > 0 && n % 3 == 1 && (n & (n - 1)) == 0;
    }
}