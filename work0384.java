package Leetcode.smart;

import java.util.Random;

/**
 * LeetCode0384 打乱数组
 */
public class work0384 {
    public static void main(String[] args) {
        Solution obj = new Solution(new int[]{1, 2, 3});
        System.out.println(obj.shuffle());
        System.out.println(obj.reset());
        System.out.println(obj.shuffle());
        System.out.println(obj.shuffle());
    }

    private static class Solution {
        private int[] nums;
        private int[] cards;
        private Random random = new Random();

        public Solution(int[] nums) {
            this.nums = nums;
            cards = new int[nums.length];
            System.arraycopy(nums, 0, cards, 0, nums.length);
        }

        public int[] reset() {
            return nums;
        }

        public int[] shuffle() {
            int n = cards.length;
            for (int i = 0; i < n - 1; i++) {
                int last = n - i;
                int index = random.nextInt(last);
                int temp = cards[index];
                cards[index] = cards[last - 1];
                cards[last - 1] = temp;
            }
            return cards;
        }
    }

}