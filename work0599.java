package Leetcode.smart;

import java.util.*;

/**
 * 0599 两个列表的最小索引总和
 */

public class work0599 {
    public static void main(String[] args) {
        work0599 w = new work0599();
        String[] restaurant = w.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"});
        LecoUtil.LecoPrint(restaurant);
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1.length > list2.length) {
            return findRestaurant(list2, list1);
        }
        HashMap<String, Integer> map = new HashMap<>(list1.length);
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int min = list1.length + list2.length;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            Integer index = map.get(list2[i]);
            if (index != null) {
                if (index + i < min) {
                    min = index + i;
                    list.clear();
                    list.add(list2[i]);
                } else if (index + i == min) {
                    list.add(list2[i]);
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }

}