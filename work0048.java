package Leetcode.smart;
/**
 * ×ó×ª
matrix[j][i] = matrix[i][l-j];
matrix[i][l-j] = matrix[l-j][l-i];
matrix[l-j][l-i] = matrix[l-i][j];
matrix[l-i][j] = temp;
 */
public class work0048 {
	public void rotate(int[][] matrix) {
		int l = matrix.length-1;
		int index=0;
		for(int i = 0;i<l;i++) {
			for(int j=i;j<l-i ;j++) {
				index++;
				int temp = matrix[j][i];
				matrix[j][i] = matrix[l-i][j];
				matrix[l-i][j] = matrix[l-j][l-i];
				matrix[l-j][l-i] = matrix[i][l-j];
				matrix[i][l-j] = temp;
			}
		}
	}
	public static void main(String[] args) {
		work0048 w = new work0048();
		int[][] nums = new int[][]
//		{{1,2,3},
//		 {4,5,6},
//		 {7,8,9},};
//		{{5, 1, 9,11},
//		 { 2, 4, 8,10},
//		 {13, 3, 6, 7},
//		 {15,14,12,16}};
		{{5, 1, 9,11,11},
		 { 2, 4, 8,10,11},
		 {13, 3, 6, 7,11},
		 {13, 3, 6, 7,11},
		 {15,14,12,16,11}};
		 w.rotate(nums);
		LecoUtil.LecoPrint(nums);
	}
}
