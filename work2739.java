package Leetcode.smart;

public class work2739 {
    public int distanceTraveled(int mainTank, int additionalTank) {
        if (mainTank < 5) return mainTank * 10; // 可以省略
        return (mainTank + Math.min(additionalTank, (mainTank - 1) / 4)) * 10;
    }

    public static void main(String[] args) {
        work2739 w = new work2739();
        System.out.println(w.distanceTraveled(1, 2));
    }
}
