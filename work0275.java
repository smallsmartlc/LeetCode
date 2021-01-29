package Leetcode.smart;

import java.util.Arrays;

/**
 * 0275.H指数II
 */
public class work0275 {

    public static void main(String[] args) {

        work0275 w = new work0275();
        int[] nums = new int[]{0, 1, 3, 5, 6};
        System.out.println(w.hIndex(nums));
    }

    public int hIndex(int[] citations) {
        //二分查找
        int n = citations.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (citations[mid] == n - mid) {
                return n-mid;
            } else if (citations[mid] > n - mid) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return n-left;
    }
}

