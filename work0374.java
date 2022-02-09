package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


/**
 * LeetCode0374 猜数字大小
 */
public class work0374 {
    public static void main(String[] args) {
        work0374 w = new work0374();
        System.out.println(w.guessNumber(1));
    }


    public int guessNumber(int n) {
        int l = 0, r = n;
        int guess = 1;
        while (guess != 0) {
            int mid = (l & r) + ((l ^ r) >> 1);
            guess = guess(mid);
            if (guess == 0) return mid;
            if (guess > 0) l = mid + 1;
            if (guess < 0) r = mid - 1;
        }
        return 0;
    }

    private int guess(int n) {
        int pick = 1;
        if (n > pick) return -1;
        else if (n < pick) return 1;
        return 0;
    }

}