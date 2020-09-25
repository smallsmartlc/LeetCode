package Leetcode.smart;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class work0207 {
    public static void main(String[] args) {
        work0207 w = new work0207();
        int[][] nums = LecoUtil.LecoNewNums(2, 3, 1, 0, 1, 2, 0, 1);
        System.out.println(w.canFinish(3, nums));
    }

    Map<Integer, List<Integer>> map = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for (int[] prerequisite : prerequisites) {
            int key = prerequisite[0];
            int value = prerequisite[1];
            if (map.containsKey(key)) {
                map.get(key).add(value);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(prerequisite[1]);
                map.put(key, list);
            }
            if(!dif(map.get(value),value)) return false;
        }
        return true;
    }

    public boolean dif(List<Integer> list, int key) {
        if(list == null) return true;
        for (Integer i : list) {
            if(i == key) return false;
            if (map.containsKey(i)) {
                if (!dif(map.get(i), key)) return false;
            }
        }
        return true;
    }
}