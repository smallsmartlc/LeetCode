package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;

/**
 * 226. 翻转二叉树
 */
public class work0228 {

    public static void main(String[] args) {

        work0228 w = new work0228();
        int[] nums = new int[]{0};
        System.out.println(w.summaryRanges(nums));
    }

    public List<String> summaryRanges(int[] nums) {

        List<String> res = new ArrayList<>();
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            String s = n + "";
            boolean flag = false;
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                flag = true;
                i++;
                len++;
            }
            if (flag) {
                s += "->" + (n + len);
                len = 0;
            }
            res.add(s);
        }

        return res;
    }

}

