package Leetcode.smart;

//334. 递增的三元子序列

import java.util.Stack;

public class work0334 {
    public static void main(String[] args) {
        work0334 w = new work0334();

        System.out.println(w.increasingTriplet(new int[]{20,100,10,12,5,13}));

    }
    public boolean increasingTriplet2(int[] nums) {
        int n = nums.length;
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        leftMin[0] = nums[0];
        rightMax[n-1] = nums[n-1];
        for (int i = 1; i < nums.length; i++) {
            leftMin[i] = Math.min(leftMin[i-1],nums[i]);
            rightMax[n-1-i] = Math.max(rightMax[n-i],nums[n-1-i]);
        }
        for (int i = 1; i < nums.length-1; i++) {
            if(nums[i] > leftMin[i-1] && nums[i] <rightMax[i+1]) return true;
        }
        return false;
    }
    public boolean increasingTriplet(int[] nums) {
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>second){
                return true;
            }else if(nums[i] < first){
                first = nums[i];
            }else{
                second = nums[i];
            }
        }
        return false;
    }
}