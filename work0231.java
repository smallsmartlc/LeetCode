package Leetcode.smart;

/**
 * 231 . 2的幂
 */
public class work0231 {

    public static void main(String[] args) {

        work0231 w = new work0231();
        System.out.println(w.isPowerOfTwo(3));
    }

    public boolean isPowerOfTwo(int n) {
        if(n<1) return false;
        return (n & n-1) == 0;
    }

}

