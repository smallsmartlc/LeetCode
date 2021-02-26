package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;

/**

 */
public class work0056 {
	public int[][] merge(int[][] intervals) {
		//排序
		for (int i = 0 ;i<intervals.length-1;i++) {
			for (int j = 0 ;j<intervals.length-1-i;j++) {
				if(intervals[j][0]>intervals[j+1][0]) {
					int[] temp = intervals[j];
					intervals[j] = intervals[j+1];
					intervals[j+1] = temp;
				}
			}
		}
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) {
			int[] temp = intervals[i];
			while(i < intervals.length-1&&intervals[i+1][0]<=temp[1]) {
				if(intervals[i+1][1]>temp[1]) {
					temp[1] = intervals[i+1][1];
				}
				i++;
			}
			list.add(temp);
		}
		int[][] res = new int[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
    }
	public static void main(String[] args) {
		work0056 w = new work0056();
		int[][] nums = new int[][]
				{{2,3},{4,5},{6,7},{8,9},{1,10}};
		int [][] res = w.merge(nums);
		LecoUtil.LecoPrint(res);
	}
}
