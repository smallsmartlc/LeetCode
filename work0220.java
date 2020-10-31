package Leetcode.smart;

//216. 组合总和 III

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class work0220 {
    public static void main(String[] args) {
        work0220 w = new work0220();
        System.out.println(w.containsNearbyAlmostDuplicate(new int[]{2147483640, 2147483641}, 1, 100));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer ceiling = set.ceiling(nums[i]);
            if (ceiling != null && ceiling <= (long) nums[i] + t) return true;
            Integer floor = set.floor(nums[i]);
            if (floor != null && nums[i] <= (long) floor + t) return true;

            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}