package Leetcode.smart;


/**
 * leetcode 256. 粉刷房子 II
 * lintcode 516. 房屋染色 II
 */
public class work0265 {

    public static void main(String[] args) {
        work0265 w = new work0265();
        int[][] costs = LecoUtil.LecoNewNums(3, 3, 14, 2, 11, 11, 14, 5, 14, 3, 10);
//        int[][] costs = LecoUtil.LecoNewNums(3, 2, 1,2,3,1,4,6);
        System.out.println(w.minCostII0(costs));
    }

    public int minCostII0(int[][] costs) {
        // write your code here
        int n = costs.length;
        if(n<1) return 0;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        dp[0] = costs[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int min = Integer.MAX_VALUE;
                for (int jj = 0; jj < k; jj++) {
                    if(jj == j) continue;
                    if(min > dp[i-1][jj]) min = dp[i-1][jj];
                }
                dp[i][j] = min + costs[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i : dp[n - 1]) {
            res = Math.min(res,i);
        }
        return res;
    }
    public int minCostII(int[][] costs) {
        // write your code here
        int n = costs.length;
        if (n < 1) return 0;
        int k = costs[0].length;
        int premin1 = 0;
        int premin2 = 0;
        int minColor = -1;
        int preMinColor = -1;
        for (int i = 0; i < n; i++) {
            int curmin1 = Integer.MAX_VALUE;
            int curmin2 = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                int cost = (preMinColor == j ? costs[i][j] + premin2 : costs[i][j] + premin1);
                if(cost <= curmin1){
                    curmin2 = curmin1;
                    curmin1 = cost;
                    minColor = j;
                }else if(cost < curmin2){
                    curmin2 = cost;
                }
            }
            preMinColor = minColor;
            premin1 = curmin1;
            premin2 = curmin2;
        }
        return premin1;
    }
}

