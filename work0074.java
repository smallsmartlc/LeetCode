package Leetcode.smart;


public class work0074 {
	public boolean searchMatrix(int[][] matrix, int target) {
		//减治,将二维转换为一维;
		//行索引 n = index/m m = index%n
		if(matrix.length<1||matrix[0].length<1) return false;
		int n = matrix.length;
		int m = matrix[0].length;
		int left = 0;
		int right = m*n-1;
		while(left<=right) {
			int mid = (left+right)/2;
			if(matrix[mid/m][mid%m]==target) return true;
			if(matrix[mid/m][mid%m]<target) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		return false;
	}
	public boolean searchMatrix2(int[][] matrix, int target) {
		//二分法
		if(matrix.length<1||matrix[0].length<1) return false;
		int n = matrix.length;
		int m = matrix[0].length;
		int left = 0;
		int right = n-1;
		
		while(left<=right) {
			int mid = (left+right)/2;
			if(matrix[mid][0]==target||matrix[mid][m-1]==target) return true;
			if(matrix[mid][0]<target&&matrix[mid][m-1]>target) {
				n=mid;
				left = 0;
				right = m-1;
				break;
			}
			if(matrix[mid][0]<target) {
				left = mid+1;
			}
			if(matrix[mid][0]>target) {
				right = mid-1;
			}
			n = mid;
		}
		while(left<=right) {
			int mid = (left+right)/2;
			if(matrix[n][mid]==target) return true;
			if(matrix[n][mid]<target) {
				left = mid+1;
			}
			if(matrix[n][mid]>target) {
				right = mid-1;
			}
		}
		return false ;
    }
	
	public static void main(String[] args) {
		work0074 w= new work0074();
		int[][] nums = new int[][]
				{{1,3,5,7},
				 {10,11,16,20},
				 {23,30,34,50},};
		int[][] nums2 = LecoUtil.LecoNewNums(3, 4, 1,3,5,7,10,11,16,20,23,30,34,50);
		System.out.println(w.searchMatrix(nums2, 10));
	}
}
