package Leetcode.smart;

/**
 * LeetCode0306 累加数
 */
public class work0306 {
    public static void main(String[] args) {
        work0306 w = new work0306();
        System.out.println(w.isAdditiveNumber("199100199"));
    }

    public boolean isAdditiveNumber(String num) {
        char[] chars = num.toCharArray();
        return dfs(chars, 0, 0, 0, 0);
    }

    private boolean dfs(char[] nums, long sum, long pre, int index, int count) {
        if (index == nums.length) return count > 2;
        long value = 0;
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[index] == '0') break; // 除 0 以外，其他数字第一位不能为 0
            value = value * 10 + nums[i] - '0';
            // 如果有两个数了,就算一下是否相等,没有两个数就随便拿了
            if (count > 1) {
                if (value < sum) continue;
                else if (value > sum) break;
            }
            if (dfs(nums, pre + value, value, i + 1, count + 1)) return true;
        }
        return false;
    }

}