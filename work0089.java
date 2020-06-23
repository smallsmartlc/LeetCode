package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;

public class work0089 {
	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<>();
		res.add(0);
		for (int i = 0; i < n; i++) {
			List<Integer> now = new ArrayList<>(res);
			for (int j=now.size()-1;j>=0;j--) {
				res.add(now.get(j)+pow(2, i));;
			}
		}
		return res;
    }
	public int pow(int a,int b) {
		int res = 1;
		for (int i = 0; i < b; i++) {
			res*=a;
		}
		return res;
	}
	public static void main(String[] args) {
		work0089 w= new work0089();
		System.out.println(w.grayCode(4));
	}
}
