package Leetcode.smart;


/**
 * LeetCode0376 摆动序列
 */
public class work0376 {
    public static void main(String[] args) {
        work0376 w = new work0376();
        System.out.println(w.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
        System.out.println(w.wiggleMaxLength1(new int[]{1, 7, 4, 9, 2, 5}));
        System.out.println(w.wiggleMaxLength2(new int[]{1, 7, 4, 9, 2, 5}));
    }

    public int wiggleMaxLength2(int[] nums) {
        // 贪心
        int res = 1;
        Integer last = null;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (last == null) {
                if(nums[i] != pre) {
                    last = nums[i];
                    res++;
                }
                continue;
            }
            if(nums[i] != last && (pre < last ^ nums[i] > last)){
                pre = last;
                res++;
            }
            last = nums[i];
        }
        return res;
    }

    public int wiggleMaxLength1(int[] nums) {
        // 动态规划优化空间
        int up = 1;
        int down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) { // 加入升序列
                up = Math.max(up, down + 1);
            } else if (nums[i] < nums[i - 1]) {
                down = Math.max(down, up + 1); // 同理
            }
        }
        return Math.max(up, down);
    }

    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[] up = new int[n]; // 最后差值为正的序列
        int[] down = new int[n]; // 最后差值为负的序列
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) { // 加入升序列
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                // 如果可以往down序列中加,该down的最后一个数必定小于等于nums[i-1],从而小于nusm[i]
                // 因为如果nums[i-1]小于down的最后一个数,那么nums[i-1]就可以当做down的最后一个数
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = Math.max(down[i - 1], up[i - 1] + 1); // 同理
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }
        return Math.max(up[n - 1], down[n - 1]);
    }

}