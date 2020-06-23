package Leetcode.smart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**

 */
public class work0052 {
	int res = 0;
	Set<Integer> rowlist = new HashSet<>();
	Set<Integer> row1 = new HashSet<>();
	Set<Integer> row2 = new HashSet<>();
	int[] qlist;
	public int totalNQueens(int n){
		qlist = new int[n];
		List<String> list = new ArrayList<>();
		addRes(n,0,-2, list);
		return res;
    }
	/**
	 * Í¨¹ıÁË,nb
	 * @param n
	 * @param x
	 * @param y
	 * @param list
	 */
	public void addRes(int n,int x,int y,List<String> list) {
		if(list.size()>=n) {
			res++;
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
				for(int j = 0;j<n;j++) {
					if(j==i) {
						temp+="Q";
					}else {
						temp+=".";
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
		work0052 w = new work0052();
		System.out.println(w.totalNQueens(4));
		
	}
}
