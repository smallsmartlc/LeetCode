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
public class work0054 {
	private List<Integer> res = new ArrayList<>();
	public List<Integer> spiralOrder2(int[][] matrix) {
		if(matrix.length==0||matrix[0].length==0) return res;
		int n = matrix.length;
		int m = matrix[0].length;
		int temp[][] = new int[n][m];
		int start=0;
		int x = 0;int y = 0;
		while(start<m*n) {
			start++;
			res.add(matrix[y][x]);
			temp[y][x] = 1;
			if((y-1<0||temp[y-1][x]!=0)&&(x+1<m&&temp[y][x+1]==0)) {
				x++;continue;
			}
			if((x+1>=m||temp[y][x+1]!=0)&&(y+1<n&&temp[y+1][x]==0)) {
				y++;continue;
			} 
			if((y+1>=n||temp[y+1][x]!=0)&&(x-1>=0&&temp[y][x-1]==0)) { 
				x--;continue;
			}
			if((x-1<0||temp[y][x-1]!=0)&&(y-1>=0&&temp[y-1][x]==0)) {
				y--;continue;
			} 
		}
		return res;
	}
	public List<Integer> spiralOrder(int[][] matrix) {
		int m = matrix.length;
		if(matrix.length==0||matrix[0].length==0) return res;
		process(0, matrix);
		return res;
    }
	public void process(int num,int[][] matrix) {
		if(matrix.length-2*num==0||matrix[0].length-2*num==0) return;
		if(matrix.length-2*num==1) {
			for(int i = num;i<matrix[0].length-num;i++) {
				res.add(matrix[num][i]);
			}
			return;
		}
		if(matrix[0].length-2*num==1) {
			for(int i = num;i<matrix.length-num;i++) {
				res.add(matrix[i][num]);
			}
			return;
		}
		for(int j = num;j<matrix[0].length-num;j++) {
			res.add(matrix[num][j]);
		}
		for(int i = num+1;i<matrix.length-num-1;i++) {
			res.add(matrix[i][matrix[0].length-1-num]);
		}
		for(int j = matrix[0].length-num-1;j>=num;j--) {
			res.add(matrix[matrix.length-1-num][j]);
		}
		for(int i = matrix.length-num-2;i>=num+1;i--) {
			res.add(matrix[i][num]);
		}
		process(num+1, matrix);
		return;
	}
	public static void main(String[] args) {
		work0054 w = new work0054();
		int[][] nums = new int[][]
				{{2,5},
				 {8,4},
				 {0,-1},};
		System.out.println(w.spiralOrder2(nums));
	}
}
