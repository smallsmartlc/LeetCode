package Leetcode.smart;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 0287. 寻找重复数
 */
public class work0287 {

    public static void main(String[] args) {

        work0287 w = new work0287();
        int[] nums = new int[]{1,3,4,2,2};
        System.out.println(w.findDuplicate1(nums));
    }
    public int findDuplicate1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(set.contains(num)){
                return num;
            }
            set.add(num);
        }
        return -1;
    }
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]){
                return nums[i];
            }
        }
        return -1;
    }
}

