package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;

/**
 * 0442 数组中重复的数据
 */

public class work0442 {
    public static void main(String[] args) {
        work0442 w = new work0442();
        System.out.println(w.findDuplicates(1));
    }

    public List<Integer> findDuplicates(int... nums) {
        // 0表示没出现(占位),-1表示出现过
        ArrayList<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] < n + 1) {
                int j = nums[i] - 1;
                if (i == j) {
                    nums[i] = -1;
                    continue;
                }
                if (nums[j] > -1) {
                    nums[i] = nums[j];
                    nums[j] = -1;
                } else {
                    res.add(nums[i]);
                    nums[i] = 0;
                }
            }
        }
        return res;
    }

    public List<Integer> findDuplicates1(int[] nums) {
        // 负数表示已经出现
        int n = nums.length;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int j = nums[i] > 0 ? nums[i] - 1 : -nums[i] - 1;
            if (nums[j] < 0) {
                res.add(j + 1);
            } else {
                nums[j] = -nums[j];
            }
        }
        return res;
    }
}