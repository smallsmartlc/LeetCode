package Leetcode.smart;

public class work0121 {
	public int maxProfit(int[] prices) {
		if (prices.length <= 0) return 0;
		int res = 0;
		int min = prices[0];
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			} else if (prices[i] - min > res) {
				res = prices[i] - min;
			}
		}
		return res;
	}
	public int maxProfit1(int[] prices) {
		int res = 0;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i; j < prices.length; j++) {
				if(prices[j]>prices[i]) {
					res = Integer.max(res, prices[j]-prices[i]);
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		work0121 w= new work0121();
		int[] prices = new int[] {7,1,5,3,6,4};
		System.out.println(w.maxProfit(prices));
	}
}
