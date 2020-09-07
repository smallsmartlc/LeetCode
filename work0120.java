package Leetcode.smart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class work0120 {
	public int minimumTotal(List<List<Integer>> triangle) {
		int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
		dp[0][0] = triangle.get(0).get(0);
		int res = Integer.MAX_VALUE;
		for (int i = 1; i < triangle.size(); i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
				} else if (j == i) {
					dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
				}
			}
		}
		for (int i : dp[triangle.size() - 1]) {
			res = Math.min(res, i);
		}
		return res;
	}
	int res = Integer.MAX_VALUE;
	public int minimumTotal1(List<List<Integer>> triangle) {
		//µÝ¹é,³¬Ê±
		dif(triangle, 0, 0, 0);
		return res;
    }
	public void dif(List<List<Integer>> triangle , int index ,int i, int value) {
		if (index>triangle.size()-1) {
			res = res>value?value:res;
			return;
		}
		value += triangle.get(index).get(i);
		dif(triangle, index+1, i, value);
		dif(triangle, index+1, i+1, value);
	}
	public static void main(String[] args) {
		work0120 w= new work0120();
		List<List<Integer>> triangle = new ArrayList<>();
		List<Integer> list1 = Arrays.asList(new Integer[] {2});
		List<Integer> list2 = Arrays.asList(new Integer[] {3,4});
		List<Integer> list3 = Arrays.asList(new Integer[] {6,5,7});
		List<Integer> list4 = Arrays.asList(new Integer[] {4,1,8,3});
		triangle.add(list1);
		triangle.add(list2);
		triangle.add(list3);
		triangle.add(list4);
		System.out.println(triangle);
		System.out.println(w.minimumTotal(triangle));
	}
}
