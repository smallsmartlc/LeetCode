package Leetcode.smart;

import java.util.LinkedList;
import java.util.List;

public class work0077 {

	List<List<Integer>> res = new LinkedList<>();

	public List<List<Integer>> combine(int n, int k) {
		// ตÝน้
		List<Integer> list = new LinkedList<>();
		find(n, k, 1, list);
		return res;
	}

	private void find(int n, int k, int index, List<Integer> list) {
		if (list.size() == k) {
			res.add(new LinkedList<>(list));
			return;
		}
		for (int i = index; i <= n; i++) {
			list.add(i);
			find(n, k, i + 1, list);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		work0077 w = new work0077();
		System.out.println(w.combine(4, 2));
	}
}
