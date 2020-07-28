package Leetcode.smart;

public class work0063 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int n = obstacleGrid.length;
		int m = obstacleGrid[0].length;
		int[][] dp = new int[n][m];
		for (int i = 0; i < m; i++) {
			if(obstacleGrid[0][i] !=0 ) break;
			dp[0][i] = 1;
		}
		for (int i = 0; i < n; i++) {
			if(obstacleGrid[i][0] !=0 ) break;
			dp[i][0] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if(obstacleGrid[i][j] != 0 ) continue;
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		return dp[n-1][m-1];
    }
	public int res = 0;
	public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
		//µÝ¹é,³¬Ê±
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
		LecoUtil.LecoPrint(nums); 
		System.out.println(w.uniquePathsWithObstacles(nums));
	}
}
