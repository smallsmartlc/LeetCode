package Leetcode.smart;

/**
 * 1014 最佳观光组合
 *
 * @author LuCong
 * @since 2022-3-9
 **/
public class work1014 {
    public static void main(String[] args) {
        work1014 w = new work1014();
        System.out.println(w.maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
    }

    public int maxScoreSightseeingPair(int[] values) {
        int dp = values[0];
        int max = 0;
        for (int i = 1; i < values.length; i++) {
            max = Math.max(max, values[i] + dp - 1);
            dp = Math.max(dp - 1, values[i]);
        }
        return max;
    }
}


