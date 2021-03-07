package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;

/**
 * 229. 求众数 II
 */
public class work0229 {

    public static void main(String[] args) {

        work0229 w = new work0229();
        int[] nums = new int[]{3, 2, 3};
        System.out.println(w.majorityElement(nums));
    }

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[][] cands = new int[2][2];
        cands[0][0] = nums[0];
        cands[0][1] = 0;
        cands[1][0] = nums[0];
        cands[1][1] = 0;
        for (int num : nums) {
            if (cands[0][0] == num) {
                cands[0][1]++;
            } else if (cands[1][0] == num) {
                cands[1][1]++;
            } else if (cands[0][1] == 0) {
                cands[0][0] = num;
                cands[0][1]++;
            } else if (cands[1][1] == 0) {
                cands[1][0] = num;
                cands[1][1]++;
            } else {
                cands[0][1]--;
                cands[1][1]--;
            }
        }
        cands[0][1] = 0;
        cands[1][1] = 0;
        for (int num : nums) {
            if (cands[0][0] == num) {
                cands[0][1]++;
            } else if (cands[1][0] == num) {
                cands[1][1]++;
            }
        }
        if (cands[0][1] > nums.length / 3) {
            res.add(cands[0][0]);
        }
        if (cands[1][1] > nums.length / 3) {
            res.add(cands[1][0]);
        }
        return res;
    }
}

