package Leetcode.smart;


/**

 */
public class work0064 {
	public int minPathSum(int[][] grid) {
		int m = grid[0].length; 
		int n = grid.length;
		if(m==0||n==0) return 0;
		int[][] temp = new int[n][m];
		temp[0][0] = grid[0][0];
		for (int i = 1; i < m; i++) {
			//上边界
			temp[0][i] = grid[0][i] + temp[0][i-1];
		}
		for (int i = 1; i < n; i++) {
			//左边界
			temp[i][0] = grid[i][0] + temp[i-1][0];
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				temp[i][j] = grid[i][j] +  Math.min(temp[i-1][j], temp[i][j-1]);
			}
		}
		return temp[n-1][m-1];
	}
	public int res = Integer.MAX_VALUE;
	public int sum;
	public int minPathSum2(int[][] grid) {
		//递归,超时
		int m = grid[0].length; 
		int n = grid.length;
		if(m==0||n==0) return 0;
		getRoad(0, 0, m, n, grid);
		return res;
    }
	public void getRoad(int x,int y,int m,int n,int[][] grid) {
		if(x==m-1&&y==n-1) {
			sum+=grid[y][x];
			if(sum<res) res = sum;
			sum-=grid[y][x];
			return;
		}
		if(x<m-1) {
			sum+=grid[y][x];
			x++;
			getRoad(x, y, m, n,grid);
			x--;
			sum-=grid[y][x];
		}
		if(y<n-1) {
			sum+=grid[y][x];
			y++;
			getRoad(x, y, m, n,grid);
			y--;
			sum-=grid[y][x];
		}
	}
	public static void main(String[] args) {
		work0064 w = new work0064();
		int[][] nums = new int[][] {
			{1,2,5},
			{3,2,1}
		};
		int[][] nums2 = new int[][] {{1,0}};
		LecoUtil.LecoPrint(nums);
		System.out.println(w.minPathSum(nums));
	}
}
