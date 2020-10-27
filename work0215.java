package Leetcode.smart;


public class work0215 {
    public static void main(String[] args) {
        work0215 w = new work0215();
        int[] nums = new int[]{2, 1};
        System.out.println(w.findKthLargest(nums, 2));
    }

    public int findKthLargest2(int[] nums, int k) {
        //todo 堆排序
        return 0;
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int l, int r, int index) {
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
}