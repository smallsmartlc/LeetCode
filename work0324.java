package Leetcode.smart;


import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 0324 摆动排序 II
 * lintcode 507. 摆动排序 II
 */
public class work0324 {

    public static void main(String[] args) {
        work0324 w = new work0324();
//        int[] nums = new int[]{1, 3, 1, 3, 2, 2};
//        int[] nums = new int[]{1,5,1,1,6,4};
        int[] nums = new int[]{4,5,5,6};
        w.wiggleSort(nums);
        LecoUtil.LecoPrint(nums);
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void wiggleSort(int[] nums) {
        int center = quickSelect(nums, 0, nums.length - 1, nums.length - 1 >> 1);
        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> right = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > center) {
                if (nums[i] == nums[center]) {
                    // 将重复的中位数放在末尾
                    right.add(nums[i]);
                } else {
                    right.addFirst(nums[i]);
                }
            } else {
                if (nums[i] == nums[center]) {
                    // 将重复的中位数放在开头
                    left.addFirst(nums[i]);
                } else {
                    left.add(nums[i]);
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = left.poll();
            } else {
                nums[i] = right.poll();
            }
        }
    }

    private int quickSelect(int[] nums, int l, int r, int target) {
        int q = sort(nums, l, r);
        if (q == target) return q;
        return q < target ? quickSelect(nums, q + 1, r, target) : quickSelect(nums, l, q - 1, target);
    }

    private int sort(int[] nums, int l, int r) {
        int temp = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= temp) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] <= temp) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = temp;
        return l;
    }

}

