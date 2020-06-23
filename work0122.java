package Leetcode.smart;

public class work0122 {
	public int maxProfit(int[] prices) {
		if (prices.length<=0) return 0;
        int res = 0;
        int buy = prices[0];
        int sale = prices[0];
        for (int i = 0; i < prices.length-1; i++) {
			while (i<prices.length-1&&prices[i]>=prices[i+1]) {
				i++;
			}
			buy = prices[i];
			while (i<prices.length-1&&prices[i]<prices[i+1]) {
				i++;
			}
			sale = prices[i];
			res += sale - buy;
		}
        return res;
    }
	public static void main(String[] args) {
		work0122 w= new work0122();
		int[] prices = new int[] {7,1,5,3,6,4};
		System.out.println(w.maxProfit(prices));
	}
}
