package Leetcode.smart;

import java.util.HashSet;

/**
 * LeetCode128.最长连续序列
 */
public class work0128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : set) {
            if (set.contains(num - 1)) continue;
            int times = 0;
            while (set.contains(num)) {
                times++;
                num = num + 1;
            }
            max = Math.max(max, times);
        }
        return max;
    }

    public static void main(String[] args) {
        work0128 w = new work0128();
        System.out.println(w.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }
}
