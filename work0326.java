package Leetcode.smart;

/**
 * leetcode 0326. 3 的幂
 */
public class work0326 {

    public static void main(String[] args) {
        work0326 w = new work0326();
        System.out.println(w.isPowerOfThree(3));
    }

    private static int max = 1162261467; // Math.pow(3,19)

    public boolean isPowerOfThree(int n) {
        return n > 0 && max % n ==0;
    }

}

