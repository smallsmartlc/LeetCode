package Leetcode.smart;

//350. 两个数组的交集 II

import java.util.*;

public class work0350 {
    public static void main(String[] args) {
        work0350 w = new work0350();
        LecoUtil.LecoPrint(w.intersect2(new int[]{1,2,2,1}, new int[]{2,2}));
    }

    public int[] intersect2(int[] nums1, int[] nums2){
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for (int i : nums2) {
            if(map.containsKey(i)){
                list.add(i);
                Integer times = map.get(i);
                if(times == 1) {
                    map.remove(i);
                }else{
                    map.put(i,times-1);
                }
            }
        }
        int[] res = new int[list.size()];
        int index = 0;
        for (Integer num : list) {
            res[index++] = num;
        }
        return res;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[Math.min(len1, len2)];
        int index = 0;
        for (int i1 = 0, i2 = 0; i1 < len1 && i2 < len2; ) {
            if (nums1[i1] == nums2[i2]) {
                res[index] = nums1[i1];
                index++;
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