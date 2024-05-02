package Leetcode.smart;

import java.util.Arrays;

public class work2798 {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        return (int) Arrays.stream(hours).filter(a -> a>=target).count();
    }

    public static void main(String[] args) {
        work2798 w = new work2798();
        System.out.println(w.numberOfEmployeesWhoMetTarget(new int[]{0,1,2,3,4}, 2));
    }
}
