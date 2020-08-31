package Leetcode.smart;

public class work0096 {
	int res = 0;

	public int numTrees(int n) {
		int res[] = new int[n + 1];
		res[0] = 1;
		res[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				res[i] += res[j - 1] * res[i - j];
			}
		}
		return res[n];
	}
	public static void main(String[] args) {
		work0096 w = new work0096();
		System.out.println(w.numTrees(3));
	}
}
