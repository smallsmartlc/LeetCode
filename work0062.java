package Leetcode.smart;
public class work0062 {
	public long uniquePaths3(int m, int n) {
		//动态规划,每个方块的总路线等于上面方块的路线+左侧方块的路线
		int[][] temp = new int[n][m];
		for (int i = 0; i < m; i++) {
			//上边界只有1种路线能够到达,即从左侧的方块;
			temp[0][i] = 1;
		}
		for (int i = 0; i < n; i++) {
			//左边界只有1种路线能够到达,即从上侧的方块;
			temp[i][0] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				temp[i][j] = temp[i-1][j]+temp[i][j-1];
			}
		}
		return temp[n-1][m-1];
	}
	public long uniquePaths1(int m, int n) {
		//数学法 ,有C(n-1)   种解法
				  //(m+n-2)
		long ans = 1;
		int min = Math.min(m, n);
		for(int i = 1;i<= min-1 ;i++) {
			ans=ans*(m+n-1-i)/i;
		}
		return (int) ans;
    }
	public int res = 0;
	public int uniquePaths2(int m, int n) {
		//递归,超时
		getRoad(0, 0, m, n);
		return res;
    }
	public void getRoad(int x,int y,int m,int n) {
		if(x==m-1&&y==n-1) {
			res++;
			return;
		}
		if(x<m-1) {
			x++;
			getRoad(x, y, m, n);
			x--;
		}
		if(y<n-1) {
			y++;
			getRoad(x, y, m, n);
			y--;
		}
	}
	public static void main(String[] args) {
		work0062 w = new work0062();
		System.out.println(w.uniquePaths3(51, 9));
	}
}
