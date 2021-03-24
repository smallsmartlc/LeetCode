package Leetcode.smart;


/**
 * leetcode 0280 摆动排序
 * lintcode 508. 摆动排序
 */
public class work0280 {

    public static void main(String[] args) {
        work0280 w = new work0280();
        int[] nums = new int[]{3, 5, 2, 1, 6, 4};
        w.wiggleSort(nums);
        LecoUtil.LecoPrint(nums);
    }

    public void wiggleSort(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 == 1 && nums[i - 1] > nums[i])
                    || (i % 2 == 0 && nums[i - 1] < nums[i])) {
                nums[i] = nums[i] + nums[i - 1];
                nums[i - 1] = nums[i] - nums[i - 1];
                nums[i] -= nums[i - 1];
            }
        }
    }
}

