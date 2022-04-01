package Leetcode.smart;

import java.util.*;

/**
 * 0954 二倍数对数组
 */

public class work0954 {
    public static void main(String[] args) {
        work0954 w = new work0954();
        System.out.println(w.canReorderDoubled(new int[]{2, 1, 2, 1, 1, 1, 2, 2}));
    }

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        if (map.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }
        Integer[] array = map.keySet().stream()
                .sorted(Comparator.comparingInt(a -> Math.abs(a)))
                .toArray(Integer[]::new);
        for (int i : array) {
            Integer num1 = map.get(i);
            Integer num2 = map.getOrDefault(2 * i, 0);
            if (num2 < num1) return false;
            if (num2 != 0) map.put(2 * i, num2 - num1);
        }
        return true;
    }
}