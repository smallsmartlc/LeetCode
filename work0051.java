package Leetcode.smart;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class work0051 {
	List<List<String>> res = new ArrayList<>();
	Set<Integer> rowlist = new HashSet<>();
	Set<Integer> row1 = new HashSet<>();
	Set<Integer> row2 = new HashSet<>();
	int[] qlist;
	public List<List<String>> solveNQueens(int n) {
		qlist = new int[n];
		List<String> list = new ArrayList<>();
		addRes(n,0,-2, list);
		return res;
    }
	/**
	 * อจนýมห,nb
	 */
	public void addRes(int n,int x,int y,List<String> list) {
		if(list.size()>=n) {
			res.add(new ArrayList<>(list));
			return;
		}
		for(int i=0;i<n;i++) {
			if(rowlist.contains(i)) {
				continue;
			}else if(row1.contains(x-i)||row2.contains(x+i)) {
				continue;
			}else {
				rowlist.add(i);
				row1.add(x-i);
				row2.add(x+i);
				String temp = "";
				for (int j = 0; j < n; j++) {
					if (j == i) {
						temp += "Q";
					} else {
						temp += ".";
					}
				}
				list.add(temp);
				addRes(n,x+1, i, list);
				list.remove(list.size()-1);
				row1.remove(x-i);
				row2.remove(x+i);
				rowlist.remove(i);
			}
		}
	}
	public static void main(String[] args) {
		work0051 w = new work0051();
		System.out.println(w.solveNQueens(4));
	}
}
