package Leetcode.smart;

//216. 组合总和 III

import java.util.*;
import java.util.stream.Collectors;

public class work0217 {
    public static void main(String[] args) {
        work0217 w = new work0217();
        System.out.println(w.containsDuplicate2(new int[]{1,2,3,4}));
    }

    public boolean containsDuplicate(int[] nums) {
        //5ms,空间复杂度最低
        int n = nums.length;
        Set<Integer> set = new HashSet<>(n);
        for (int num : nums) {
            if(!set.add(num)) return true;
        }
        return false;
    }
    public boolean containsDuplicate2(int[] nums) {
        //练习流式计算,本题中效率不高
//        return Arrays.stream(nums).boxed().collect(Collectors.toSet()).size() != nums.length;//转为set,9ms
        return Arrays.stream(nums).distinct().count() != nums.length;//去重,8ms
    }
}