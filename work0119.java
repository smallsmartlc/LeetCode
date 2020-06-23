package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;

public class work0119 {
	//还可以数学法Cn1到Cnn
	public List<Integer> getRow(int rowIndex) {
		List<Integer> dp = new ArrayList<>();
		dp.add(1);
		for (int i = 1; i <= rowIndex; i++) {
			for (int j = i-1; j > 0 ; j--) {
				dp.set(j, dp.get(j)+dp.get(j-1));
			}
			dp.add(1);
		}
		return dp;
    }
	public static void main(String[] args) {
		work0119 w= new work0119();
		System.out.println(w.getRow(5));
	}
}
