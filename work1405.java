package Leetcode.smart;

/**
 * LeetCode1405 最长快乐字符串
 * @author LuCong
 * @since 2020-10-30
 **/
public class work1405 {
    public static void main(String[] args) {
        work1405 w = new work1405();
        System.out.println(w.longestDiverseString(7, 1, 0));
    }

    public String longestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        int[] nums = {a, b, c};
        char[] chars = {'a', 'b', 'c'};
        while (nums[0] > 0 || nums[1] > 0 || nums[2] > 0) {
            int max = getMaxIndex(nums);
            int l = res.length();
            if (l > 1 && res.charAt(l - 1) == chars[max] && res.charAt(l - 2) == chars[max]) {
                int sec = getMaxIndex(nums, max); // 获得第二多的字母
                if(nums[sec] == 0) break;
                res.append(chars[sec]);
                nums[sec]--;
            } else {
                res.append(chars[max]); // 最多的字母
                nums[max]--;
            }
        }
        return res.toString();
    }

    private int getMaxIndex(int[] nums) {
        return getMaxIndex(nums, -1);
    }

    private int getMaxIndex(int[] nums, int exclude) {
        int max = -1;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i == exclude) continue; // 排除掉最大值即可返回第二大的值
            if (nums[i] > max) {
                max = nums[i];
                res = i;
            }
        }
        return res;
    }

}







