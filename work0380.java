package Leetcode.smart;


import java.util.*;

/**
 * LeetCode0380 O(1) 时间插入、删除和获取随机元素
 */
public class work0380 {
    public static void main(String[] args) {
        work0380 w = new work0380();
        String[] strings = {"insert", "insert", "insert", "insert", "getRandom", "getRandom", "remove", "insert", "getRandom"};
        Integer[] ints = {1, 10, 20, 30, null,null,1, 2, null};
        RandomizedSet obj = new RandomizedSet();
        for (int i = 0; i < strings.length; i++) {
            switch (strings[i]){
                case "insert":
                    System.out.println(obj.insert(ints[i]));break;
                case "remove" :
                    System.out.println(obj.remove(ints[i]));break;
                case "getRandom" :
                    System.out.println(obj.getRandom());break;
            }
        }
    }

    private static class RandomizedSet {

        private ArrayList<Integer> list;
        private Map<Integer,Integer> map;
        private Random rand = new Random();

        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if(map.containsKey(val)){
                return false;
            }
            map.put(val,list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            Integer index = map.remove(val);
            if(index == null){
                return false;
            }
            int last = list.size() - 1;
            if(index != last) {
                Integer lastValue = list.get(last);
                list.set(index, lastValue);
                map.put(lastValue,index);
            }
            list.remove(last);
            return true;
        }

        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }
}