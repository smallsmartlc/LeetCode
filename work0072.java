package Leetcode.smart;

import java.util.HashSet;
import java.util.Set;

public class work0072 {
	public void setZeroes(int[][] matrix) {
		Set<Integer> rowset = new HashSet<>();
		Set<Integer> colset = new HashSet<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j]==0) {
					rowset.add(i);
					colset.add(j);
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(rowset.contains(i)||colset.contains(j)) {
					matrix[i][j]=0;
				}
			}
		}
    }
	public static void main(String[] args) {
		work0072 w= new work0072();
//		int[][] nums = new int[][]
//				{{1,2,3},
//				 {4,0,6},
//				 {7,8,9},};
		int[][] nums = LecoUtil.LecoNewNums(4, 3, 1,2,3,4,0,6,7,8,9,1,2,3);
		w.setZeroes(nums);
		LecoUtil.LecoPrint(nums);
	}
}
