package Leetcode.smart;

/**
 * LeetCode0307 区域和检索 - 数组可修改
 */
public class work0307 {
    public static void main(String[] args) {
        work0307 w = new work0307();
        NumArray obj = new NumArray(-1);
        System.out.println(obj.sumRange(0, 2));
        obj.update(1, 2);
        System.out.println(obj.sumRange(0, 2));
    }

    private static class NumArray {
        private int[] tree;
        private int n;

        public NumArray(int... nums) {
            n = nums.length;
            if (n < 1) return;
            tree = new int[2 * n];
            for (int i = n; i < 2 * n; i++) {
                tree[i] = nums[i - n];
            }
            for (int i = n - 1; i > 0; i--) {
                tree[i] = tree[i * 2] + tree[i * 2 + 1];
            }
        }

        public void update(int index, int val) {
            index += n;
            tree[index] = val;
            while (index > 0) {
                int left = index;
                int right = index;
                if (index % 2 == 0) {
                    //index是左边节点
                    right = index + 1;
                } else {
                    //index是右边节点
                    left = index - 1;
                }
                tree[index /= 2] = tree[left] + tree[right];
            }
        }

        public int sumRange(int left, int right) {
            left += n;
            right += n;
            int sum = 0;
            while (left <= right) {
                //如果left是左节点,求和时直接往上找,否则就加上这个值,放弃这个树往右找
                //right 同理
                if (left % 2 == 1) {
                    // 右节点
                    sum += tree[left];
                    left++;
                }
                if (right % 2 == 0) {
                    // 左节点
                    sum += tree[right];
                    right--;
                }
                left /= 2;
                right /= 2;
            }
            return sum;
        }
    }
}