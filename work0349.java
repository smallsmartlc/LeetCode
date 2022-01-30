package Leetcode.smart;

//349. 两个数组的交集

import java.util.Arrays;
import java.util.HashSet;

public class work0349 {
    public static void main(String[] args) {
        work0349 w = new work0349();
        LecoUtil.LecoPrint(w.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> rSet = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if(set.contains(i)) rSet.add(i);
        }
        int[] res = new int[rSet.size()];
        int index = 0;
        for (Integer num : rSet) {
            res[index++] = num;
        }
        return res;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[Math.min(len1, len2)];
        int index = 0;
        for (int i1 = 0, i2 = 0; i1 < len1 && i2 < len2; ) {
            if (nums1[i1] == nums2[i2]) {
                if (index == 0 || nums1[i1] != res[index - 1]) {
                    res[index] = nums1[i1];
                    index++;
                }
                i1++;
                i2++;
            } else if (nums1[i1] < nums2[i2]) {
                i1++;
            } else {
                i2++;
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }
}