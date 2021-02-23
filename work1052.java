package Leetcode.smart;

/**
 * LeetCode1052 爱生气的书店老板
 *
 * @author LuCong
 * @since 2020-10-30
 **/
public class work1052 {
    public static void main(String[] args) {
        work1052 w = new work1052();
        System.out.println(w.maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5},
                new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int allCus = 0;
        int n = grumpy.length;
        int max = 0;
        for (int i = 0; i < X; i++) {
            if(grumpy[i] > 0){
                grumpy[i] = customers[i];
                max += customers[i];
            } else {
                allCus += customers[i];
            }
        }
        for (int i = X,temp = max; i < n; i++) {
            if(grumpy[i] > 0){
                grumpy[i] = customers[i];
            } else {
                allCus += customers[i];
            }
            temp += (grumpy[i]-grumpy[i-X]);
            if(temp > max) max = temp;
        }
        return allCus + max;
    }

    public int maxSatisfied1(int[] customers, int[] grumpy, int X) {
        // 直观解法
        int allCus = 0;
        int n = grumpy.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] > 0) {
                grumpy[i] = customers[i];
            } else {
                allCus += customers[i];
            }
        }
        int dp[] = new int[n];
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            int temp = 0;
            for (int j = 0; i + j < dp.length && j < X; j++) {
                temp += grumpy[i + j];
            }
            if (temp > max) max = temp;
        }
        return allCus + max;
    }
}


