package Leetcode.smart;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 0292. Nim 游戏
 */
public class work0292 {

    public static void main(String[] args) {

        work0292 w = new work0292();
        System.out.println(w.canWinNim(4));
    }

    public boolean canWinNim(int n) {
        return (n & 3) != 0;
    }

}

