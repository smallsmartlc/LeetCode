package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode0163 缺失的区间  (会员)
 * LintCode0641 丢失的间隔
 */

public class work0163 {
    public static void main(String[] args) {
        work0163 w = new work0163();
        System.out.println(w.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (nums.length < 1) {
            res.add(range(lower, upper));
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < lower) {
                continue;
            }
            if (nums[i] > upper) {
                res.add(range(lower, upper));
                break;
            }
            if (nums[i] == upper && lower + 1 < upper) {
                res.add(range(lower, upper - 1));
                break;
            }
            if (nums[i] > lower) {
                res.add(range(lower, nums[i] - 1));
            }
            lower = nums[i] + 1;
        }
        if (nums[nums.length - 1] < upper) res.add(range(nums[nums.length - 1] + 1, upper));
        return res;
    }

    private String range(int lower, int upper) {
        if (lower == upper) {
            return Integer.toString(lower);
        }
        return lower + "->" + upper;
    }

}
