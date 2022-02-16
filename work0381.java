package Leetcode.smart;


import java.util.*;

/**
 * LeetCode0381 O(1) 时间插入、删除和获取随机元素 - 允许重复
 */
public class work0381 {
    public static void main(String[] args) {
        work0381 w = new work0381();
        String[] strings = {"insert", "insert", "remove", "insert", "remove", "getRandom"};
        Integer[] ints = {0, 1, 0, 2, 1, null};
        RandomizedCollection obj = new RandomizedCollection();
        for (int i = 0; i < strings.length; i++) {
            switch (strings[i]) {
                case "insert":
                    System.out.println(obj.insert(ints[i]));
                    break;
                case "remove":
                    System.out.println(obj.remove(ints[i]));
                    break;
                case "getRandom":
                    System.out.println(obj.getRandom());
                    break;
            }
        }
    }

    private static class RandomizedCollection {

        private Map<Integer, Set<Integer>> map;
        private List<Integer> list;
        private Random random = new Random();

        public RandomizedCollection() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            Set<Integer> oldValue = map.putIfAbsent(val, new HashSet<>());
            list.add(val);
            if (oldValue == null || oldValue.isEmpty()) {
                map.get(val).add(list.size() - 1);
                return true;
            }
            oldValue.add(list.size() - 1);
            return false;
        }

        public boolean remove(int val) {
            Set<Integer> value = map.get(val);
            if (value == null || value.isEmpty()) {
                return false;
            }
            int index = value.iterator().next(); // 随便选一个删
            int lastIndex = list.size() - 1; // 和最后一个值交换
            Integer lastElement = list.get(lastIndex);
            if (val != lastElement) {
                list.set(index, lastElement);
                Set<Integer> set = map.get(lastElement);
                set.remove(lastIndex);
                set.add(index);
                value.remove(index);
            } else { // 直接删除最后一个
                value.remove(lastIndex);
            }
            list.remove(lastIndex);
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}