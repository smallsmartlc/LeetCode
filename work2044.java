package Leetcode.smart;

/**
 * 2044 统计按位或能得到最大值的子集数目
 *
 * @author LuCong
 * @since 2022-2-9
 **/
public class work2044 {
    public static void main(String[] args) {
        work2044 w = new work2044();
        System.out.println(w.countMaxOrSubsets(2, 2, 2));
    }


    public int countMaxOrSubsets(int... nums) {
        dfs(nums, 0, 0);
        return time;
    }

    private int res = 0;
    private int time = 0;

    private void dfs(int[] nums, int start, int value) {
        if (start == nums.length) {
            if (value > res) {
                res = value;
                time = 1;
            } else if (value == res) time++;
            return;
        }
        dfs(nums, start + 1, value);
        dfs(nums, start + 1, value | nums[start]);
    }
}


