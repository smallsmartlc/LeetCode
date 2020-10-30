package Leetcode.smart;

//216. 组合总和 III

import java.util.*;

public class work0219 {
    public static void main(String[] args) {
        work0219 w = new work0219();
        System.out.println(w.containsNearbyDuplicate(new int[]{1, 2, 3, 4}, 3));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> set = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            Integer p = set.put(nums[i], i);
            if (p != null && (i - p) < k + 1) return true;
        }
        return false;
    }
}