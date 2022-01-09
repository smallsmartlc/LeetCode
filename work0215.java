package Leetcode.smart;

/**
 * LeetCode0215 数组中的第K个最大元素
 */

import java.util.*;

public class work0215 {
    public static void main(String[] args) {
        work0215 w = new work0215();
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(w.findKthLargest3(nums, 2));
        System.out.println(Arrays.toString(nums));
    }

    public int findKthLargest0(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest3(int[] nums, int k) {
        // 手写堆排序
        new HeapSort(nums,k);
        return nums[nums.length - k];
    }

    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            priorityQueue.add(num);
            if (priorityQueue.size() > k) priorityQueue.poll();
        }
        return priorityQueue.peek();
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int l, int r, int index) {
        // 快速排序的过程可以确定一个元素的最终位置
        int q = sort(nums, l, r);
        if (q == index) {
            return nums[q];
        } else {
            return q < index ? quickSelect(nums, q + 1, r, index) : quickSelect(nums, l, q - 1, index);
        }
    }

    private int sort(int[] nums, int l, int r) {
        int i = l;
        int j = r;
        int temp = nums[l];
        while (i < j) {
            while (i < j && nums[j] > temp) j--;
            nums[i] = nums[j];
            while (i < j && nums[i] <= temp) i++;
            nums[j] = nums[i];
        }
        nums[i] = temp;
        return i;
    }

    private static class HeapSort {
        private int[] arr;

        private void swap(int i, int j) {
            int temp = this.arr[i];
            this.arr[i] = this.arr[j];
            this.arr[j] = temp;
        }

        // parent(i) = floor((i - 1)/2)
        //left(i)   = 2i + 1
        //right(i)  = 2i + 2
        public HeapSort(int[] arr,int k) {
            if (arr.length < 1) return;
            this.arr = arr;
            // 从最后一个根节点开始将数组变成堆
            int lastIndex = arr.length - 1;
            int lastRoot = (lastIndex - 1) >> 1;
            for (int i = lastRoot; i >= 0; i--) {
                // 将数组堆化
                maxHeapify(i, lastIndex);
            }
            for (int i = lastIndex; i > lastIndex-k; i--) {
                // 将根节点（最大值）与尾部的结点交换
                // 并检查交换后是否除了尾部的结点是否是一个最大堆
                swap(0, i);
                maxHeapify(0, i - 1);
            }
        }

        private void maxHeapify(int i, int lastIndex) {
            int left = 2 * i + 1;
            if (left > lastIndex) return;
            int right = left + 1;
            if (right <= lastIndex && arr[right] > arr[left]) {
                left = right; // 找出更大的一个子节点
            }
            if (arr[left] > arr[i]) {
                // 子节点大于父节点，交换
                swap(left, i);
                maxHeapify(left, lastIndex); // 交换后的子节点检查是否符合最大堆
            }
        }
    }
}