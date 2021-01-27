package Leetcode.smart;

/**
 * 0264
 */
public class work0264 {

    public static void main(String[] args) {

        work0264 w = new work0264();
        System.out.println(w.nthUglyNumber2(10));
    }

    public int nthUglyNumber2(int n){
        //普通解法,动态规划
        int[] nums = new int[n];
        nums[0] = 1;
        int ugly, i2 = 0, i3 = 0, i5 = 0;

        for(int i = 1; i < n; ++i) {
            ugly = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
            nums[i] = ugly;

            if (ugly == nums[i2] * 2) ++i2;
            if (ugly == nums[i3] * 3) ++i3;
            if (ugly == nums[i5] * 5) ++i5;
        }
        return nums[n-1];
    }

    public int nthUglyNumber(int n) {
        //大量运算时使用一个容器保存
        return new Ugly().nums[n-1];
    }
    private static class Ugly {
        public int[] nums = new int[1690];
        Ugly() {
            nums[0] = 1;
            int ugly, i2 = 0, i3 = 0, i5 = 0;

            for(int i = 1; i < 1690; ++i) {
                ugly = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
                nums[i] = ugly;

                if (ugly == nums[i2] * 2) ++i2;
                if (ugly == nums[i3] * 3) ++i3;
                if (ugly == nums[i5] * 5) ++i5;
            }
        }
    }
}

