package Leetcode.smart;

/**
 * 0042 接雨水
 *
 * @author LuCong
 * @since 2022-3-11
 **/
public class work0042 {

    public static void main(String[] args) {
        work0042 w = new work0042();
        int[] nums = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(w.trap(nums));
    }

    public int trap2(int[] height) {
        // 双指针
        int n = height.length;
        int l = 0, r = n - 1, dpl = 0, dpr = 0;
        int ans = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                dpl = Math.max(dpl, height[l]);
                ans += dpl - height[l++];
            } else {
                dpr = Math.max(dpr, height[r]);
                ans += dpr - height[r--];
            }
        }
        return ans;
    }

    public int trap(int[] height) {
        int n = height.length;
        int[] dpl = new int[n]; // 左边的最大值
        int[] dpr = new int[n]; // 右边的最大值
        dpl[0] = height[0];
        dpr[n - 1] = height[n - 1];
        for (int i = 1, j = n - 2; i < n; i++, j--) {
            dpl[i] = Math.max(height[i], dpl[i - 1]);
            dpr[j] = Math.max(height[j], dpr[j + 1]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(dpl[i], dpr[i]) - height[i];
        }
        return ans;
    }
}
