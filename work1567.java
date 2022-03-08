package Leetcode.smart;

/**
 * LeetCode1567 乘积为正数的最长子数组长度
 *
 * @author LuCong
 * @since 2022-3-8
 **/
public class work1567 {
    public static void main(String[] args) {
        work1567 w = new work1567();
        System.out.println(w.getMaxLen1(new int[]{0, 0, 0, 0, 0}));
    }

    public int getMaxLen1(int[] nums) {
        int num = 0;
        int n = nums.length;
        int l = n; // 最左侧负数;
        int r = -1; // 最右侧负数
        int res = 0;
        int start = 0; // 当前数组的起始值
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                num++;
                l = Math.min(l, i);
                r = Math.max(r, i);
            }
            // 0,1,2,3 start0,len4 ,r = 3,min = (r - start)
            if (nums[i] == 0) { // 数组结束,重置
                int min = Math.min(l - start, i - 1 - r) + 1;// 左边或者右边取最短的一个负数
                res = Math.max(res, num % 2 == 0 ? i - start : i - start - min);
                num = 0;
                l = n;
                r = start;
                start = i + 1;
            }
        }
        int min = Math.min(l - start, n - 1 - r) + 1; // 左边或者右边取最短的一个负数
        res = Math.max(res, num % 2 == 0 ? n - start : n - start - min);
        return res;
    }

    public int getMaxLen(int[] nums) {
        int max = nums[0] > 0 ? 1 : 0;
        int min = nums[0] < 0 ? 1 : 0;
        int res = max;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                max++;
                min = min > 0 ? min + 1 : 0;
            } else if (nums[i] < 0) {
                int t = min > 0 ? min + 1 : 0;
                min = max + 1;
                max = t;
            } else {
                min = 0;
                max = 0;
            }
            if (max > res) res = max;
        }
        return res;
    }

}





