package Leetcode.smart;

public class work0134 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int total = 0;
		int start = 0;
		int cur = 0;
		for (int i = 0; i < cost.length; i++) {
			cur += gas[i] - cost[i];
			total += cur;
			if (cur < 0) {
				start = i + 1;
				cur = 0;
			}
		}
		return total < 0 ? -1 : start;
	}
	public static void main(String[] args) {
		work0134 w= new work0134();
		int[] gas = new int[] {1,2,3,4,5};
		int[] cost = new int[] {3,4,5,1,2};
		System.out.println(w.canCompleteCircuit(gas, cost));
	}
}
