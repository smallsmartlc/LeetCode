package Leetcode.smart;
public class work0062 {
	public long uniquePaths3(int m, int n) {
		//��̬�滮,ÿ���������·�ߵ������淽���·��+��෽���·��
		int[][] temp = new int[n][m];
		for (int i = 0; i < m; i++) {
			//�ϱ߽�ֻ��1��·���ܹ�����,�������ķ���;
			temp[0][i] = 1;
		}
		for (int i = 0; i < n; i++) {
			//��߽�ֻ��1��·���ܹ�����,�����ϲ�ķ���;
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
		//��ѧ�� ,��C(n-1)   �ֽⷨ
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
		//�ݹ�,��ʱ
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
