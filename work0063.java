package Leetcode.smart;


/**
	回溯法以及动态规划
 */
public class work0063 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid[0].length; 
		int n = obstacleGrid.length;
		if(m==0||n==0) return 0;
		if(obstacleGrid[n-1][m-1]==1||obstacleGrid[0][0]==1) return 0;
		int[][] temp = new int[n][m];
		temp[0][0] = 1;
		for (int i = 1; i < m; i++) {
			//上边界
			if(obstacleGrid[0][i]==1||temp[0][i-1] == 0) {
				temp[0][i] = 0;
			}else {
				temp[0][i] = 1;
			} 
		}
		for (int i = 1; i < n; i++) {
			//左边界
			if(obstacleGrid[i][0]==1||temp[i-1][0] == 0) {
				temp[i][0] = 0;
			}else {
				temp[i][0] = temp[i-1][0];
			} 
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if(obstacleGrid[i][j]==1) {
					temp[i][j] = 0;
				}else {
					temp[i][j] = temp[i-1][j]+temp[i][j-1];
				}
			}
		}
		LecoUtil.LecoPrint(temp);
		return temp[n-1][m-1];
	}
	public int res = 0;
	public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
		//递归,超时
		int m = obstacleGrid[0].length; 
		int n = obstacleGrid.length;
		if(m==0||n==0) return 0;
		if(obstacleGrid[n-1][m-1]==1||obstacleGrid[0][0]==1) return 0;
		getRoad(0, 0, m, n, obstacleGrid);
		return res;
    }
	public void getRoad(int x,int y,int m,int n,int[][] obstacleGrid) {
		if(x==m-1&&y==n-1) {
			res++;
			return;
		}
		if(x<m-1&&obstacleGrid[y][x+1]!=1) {
			x++;
			getRoad(x, y, m, n,obstacleGrid);
			x--;
		}
		if(y<n-1&&obstacleGrid[y+1][x]!=1) {
			y++;
			getRoad(x, y, m, n,obstacleGrid);
			y--;
		}
	}
	public static void main(String[] args) {
		work0063 w = new work0063();
		int[][] nums = new int[][] {
			{0,0,0},
			{0,1,0},
			{0,0,0}
		};
		int[][] nums2 = new int[][] {{1,0}};
		LecoUtil.LecoPrint(nums); 
		System.out.println(w.uniquePathsWithObstacles(nums));
	}
}
