package Leetcode.smart;

import java.util.Stack;

/**
 * Leetcode2104 子数组范围和
 *
 * @author LuCong
 * @since 2022-3-4
 **/
public class work2104 {
    public static void main(String[] args) {
        work2104 w = new work2104();
        System.out.println(w.subArrayRanges1(new int[]{1, 2, 3}));
    }

    public long subArrayRanges1(int[] nums) {
        // 使用单调栈维护每一个元素左侧比他大或小的第一个元素
        int n = nums.length;
        int[] minLeft = new int[n]; // 左侧比它小的数的下标
        int[] minRight = new int[n]; // 右侧比它小的数的下标
        int[] maxLeft = new int[n]; // 左侧比它大的数的下标
        int[] maxRight = new int[n];// 右侧比它大的数的下标
        Stack<Integer> minStack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!minStack.isEmpty() && nums[minStack.peek()] > nums[i]) {
                minStack.pop(); // 保证栈中的数是左边的最小值
            }
            minLeft[i] = minStack.empty() ? -1 : minStack.peek();
            minStack.push(i);

            while (!maxStack.isEmpty() && nums[maxStack.peek()] <= nums[i]) {
                maxStack.pop(); // 栈中的数是左边的最大值
            }
            maxLeft[i] = maxStack.isEmpty() ? -1 : maxStack.peek();
            maxStack.push(i);
        }
        minStack.clear();
        maxStack.clear();
        for (int i = n - 1; i > -1; i--) { //倒序遍历检查右边
            while (!minStack.isEmpty() && nums[minStack.peek()] >= nums[i]) { //这里避免重复,设置同一个数的不同下标,前一个下标,小于后一个下标
                minStack.pop(); // 保证栈中的数是右边的最小值
            }
            minRight[i] = minStack.empty() ? n : minStack.peek();
            minStack.push(i);

            while (!maxStack.isEmpty() && nums[maxStack.peek()] <= nums[i]) {
                maxStack.pop(); // 栈中的数是右边的最大值
            }
            maxRight[i] = maxStack.isEmpty() ? n : maxStack.peek();
            maxStack.push(i);
        }
        long sumMax = 0, sumMin = 0;
        for (int i = 0; i < n; i++) {
            sumMax += (long) (maxRight[i] - i) * (i - maxLeft[i]) * nums[i]; // nums[i]作为子数组最大值的贡献次数
            sumMin += (long) (minRight[i] - i) * (i - minLeft[i]) * nums[i]; // nums[i]作为子数组最小值的贡献次数
        }
        return sumMax - sumMin;
    }

    public long subArrayRanges(int[] nums) {
        // 暴力法+dp优化+滚动数组
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int max = nums[i]; // i 到 j的最大值
            int min = nums[i]; // i 到 j的最小值
            for (int j = i + 1; j < n; j++) {
                max = Math.max(nums[j], max);
                min = Math.min(nums[j], min);
                ans += (max - min);
            }
        }
        return ans;
    }
}


