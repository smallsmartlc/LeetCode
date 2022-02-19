package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode0969 煎饼排序
 */

public class work0969 {
    public static void main(String[] args) {
        work0969 w = new work0969();
        System.out.println(w.pancakeSort(new int[]{3, 2, 4, 1}));
        System.out.println(w.pancakeSort(new int[]{1, 2, 3}));
    }

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            int max = 0;
            for (int j = 1; j <= i; j++) {
                if (arr[j] > arr[max]) max = j;
            }
            if (max == i) {
                continue;
            }
            reverse(arr, max);
            list.add(max + 1);
            reverse(arr, i);
            list.add(i + 1);
        }
        return list;
    }

    private void reverse(int[] arr, int k) {
        for (int l = 0, temp; l < k; l++, k--) {
            temp = arr[l];
            arr[l] = arr[k];
            arr[k] = temp;
        }
    }

}