package Leetcode.smart;

import java.util.*;

/**
 * LeetCode0170 两数之和 III-数据结构设计  (会员)
 * LintCode0607
 */

public class work0170 {
    public static void main(String[] args) {
        work0170 w = new work0170();
        TwoSum o = new TwoSum();
        o.add(1);
        o.add(3);
        o.add(5);
        System.out.println(o.find(4));
        System.out.println(o.find(7));
    }

    public static class TwoSum {
        /**
         * @param number: An integer
         * @return: nothing
         */
        Map<Integer, Integer> map = new HashMap<>();

        public void add(int number) {
            // write your code here
            Integer t;
            if ((t = map.get(number)) != null && t < 2) {
                map.put(number, 2);
            } else {
                map.put(number, 1);
            }
        }

        /**
         * @param value: An integer
         * @return: Find if there exists any pair of numbers which sum is equal to the value.
         */
        public boolean find(int value) {
            // write your code here
            for (Integer key : map.keySet()) {
                Integer t;
                if ((t = map.get(value - key)) != null) {
                    if (key.equals(value - key) && t < 2) continue;
                    return true;
                }
            }
            return false;
        }
    }

}
