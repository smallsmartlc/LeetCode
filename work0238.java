package Leetcode.smart;


/**
 * 238. 除自身以外数组的乘积
 */
public class work0238 {

    public static void main(String[] args) {

        work0238 w = new work0238();
        int[] nums = new int[]{1,2,3,4};
        LecoUtil.LecoPrint(w.productExceptSelf2(nums));
    }

    public int[] productExceptSelf2(int[] nums) {
        //优化空间复杂度,思路,用结果数组保存右边,再动态构造左边
        int n = nums.length;
        int[] output = new int[n];
        output[n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            output[i] = nums[i+1] * output[i+1];
        }
        int left = 1;
        for (int i = 0; i < n-1; i++) {
            output[i] *= left;
            left*= nums[i];
        }
        output[n-1] = left;
        return output;
    }

    public int[] productExceptSelf(int[] nums) {
        //使用两个数组来保存一个数左边的和以及右边的和
        int n = nums.length;
        int[] output = new int[n];
        int[] left = new int[n];
        int [] right = new int[n];
        left[0] = 1;
        right[n-1] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = nums[i-1]*left[i-1];
        }
        for (int i = n-2; i >= 0; i--) {
            right[i] = nums[i+1] * right[i+1];
        }
        for (int i = 0; i < n; i++) {
            output[i] = left[i]*right[i];
        }
        return output;
    }
}

