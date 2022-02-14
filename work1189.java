package Leetcode.smart;

import java.util.HashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * 1189 “气球” 的最大数量
 *
 * @author LuCong
 * @since 2020-10-30
 **/
public class work1189 {
    public static void main(String[] args) throws InterruptedException {
        work1189 w = new work1189();
        System.out.println(w.maxNumberOfBalloons("nlaebolko"));
    }


    public int maxNumberOfBalloons(String text) {
        int res = Integer.MAX_VALUE;
        int[] map = new int[6]; // a,b,l,n,o
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map[hash(chars[i])]++;
        }
        map[2] >>= 1;
        map[4] >>=1;
        for (int i = 0; i < 5; i++) {
            res = Math.min(res,map[i]);
        }
        return res;
    }

    private int hash(char c) {
        switch (c) {
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'l':
                return 2;
            case 'n':
                return 3;
            case 'o':
                return 4;
        }
        return 5;
    }
}







