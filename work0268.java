package Leetcode.smart;

import java.util.HashSet;
import java.util.Set;

/**
 * 0268. 丢失的数字
 */
public class work0268 {

    public static void main(String[] args) {

        work0268 w = new work0268();
        int[] nums = new int[]{3,0,1};
        System.out.println(w.missingNumber2(nums));
    }
    public int missingNumber(int[] nums) {
        //简单粗暴,直接hash法
        int n = nums.length;
        Set<Integer> set = new HashSet<>(n);
        for (int i = 0; i <= n; i++) {
            set.add(i);
        }
        for (int i = 0; i < n; i++) {
            set.remove(nums[i]);
        }
        return set.iterator().next();
    }
    public int missingNumber2(int[] nums) {
        //位运算,永远的神
        int flag = nums.length;
        for (int i = 0; i < nums.length; i++) {
            flag ^= i;
            flag ^= nums[i];
        }
        return flag;
    }

    public int missingNumber3(int[] nums){
        //数学法,用高斯定理直接获得1..n的和,再一个个减就完事
        int n = nums.length;
        int sum = n*(n+ 1)/2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

}

