package Leetcode.smart;

/**
 * LeetCode0540 有序数组中的单一元素
 */

public class work0540 {
    public static void main(String[] args) {
        work0540 w = new work0540();
        System.out.println(w.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
        System.out.println(w.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(w.singleNonDuplicate(new int[]{1, 2, 2, 3, 3}));
        System.out.println(w.singleNonDuplicate(new int[]{1, 1, 2, 2, 3}));
    }

    public int singleNonDuplicate2(int[] nums) {
        //通过偶数下标二分查找
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            mid -= mid & 1;//使成为偶数
            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }

    public int singleNonDuplicate1(int[] nums) {
        // 简化 ,如果mid左边有偶数个就比较mid和mid+1
        // 如果mid左边有奇数个就比较mid和mid-1
        // 当mid为奇数 mid - 1 = mid ^ 1
        // 当mid 为偶数 mid + 1 = mid ^ 1
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if ((mid == 0 || nums[mid] != nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] != nums[mid + 1])) {
                return nums[mid];
            }
            if (nums[mid] == nums[mid ^ 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }

    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if ((mid == 0 || nums[mid] != nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] != nums[mid + 1])) {
                return nums[mid];
            }
            if ((nums[mid] == nums[mid - 1]) ^ ((mid & 1) == 1)) {
                // 左边有奇数个和偶数个数字的不同情况
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}