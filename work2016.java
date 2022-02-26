package Leetcode.smart;

/**
 * 2016 增量元素之间的最大差值
 *
 * @author LuCong
 * @since 2022-2-9
 **/
public class work2016 {
    public static void main(String[] args) {
        work2016 w = new work2016();
        System.out.println(w.maximumDifference(new int[]{7, 1, 5, 4}));
    }

    public int maximumDifference(int[] nums) {
        int res = -1;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > pre) {
                res = Math.min(res, nums[i] - pre);
            } else {
                pre = nums[i];
            }
        }
        return res;
    }
}


