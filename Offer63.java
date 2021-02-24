package Leetcode.smart;

/**
 * LeetCode0832 翻转图像
 *
 * @author LuCong
 * @since 2020-10-30
 **/
public class Offer63 {
    public static void main(String[] args) {
        Offer63 o = new Offer63();
        System.out.println(o.maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(prices[i] < min){
                min = prices[i];
            }else if(prices[i] - min > res){
                res = prices[i] - min;
            }
        }
        return res;
    }
}


