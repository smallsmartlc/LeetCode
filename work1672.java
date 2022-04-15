package Leetcode.smart;

//1672 最富有客户的资产总量

import java.util.Arrays;
import java.util.Comparator;

public class work1672 {
    public static void main(String[] args) {
        work1672 w = new work1672();
        System.out.println(w.maximumWealth(LecoUtil.LecoNewNums(3, 2,
                1, 2, 3, 3, 2, 1)));
    }

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            if (account[0] > max) max = account[0];
            for (int i = 1; i < account.length; i++) {
                account[i] += account[i - 1];
                if (account[i] > max) max = account[i];
            }
        }
        return max;
    }

}