package Leetcode.smart;


public class work0059 {
	public int[][] generateMatrix2(int n) {
		int[][] res = new int[n][n];
		int len = res.length;
		int start=0;
		int x = 0;int y = 0;
		while(start<n*n) {
			start++;
			res[y][x] = start;
			if((y-1<0||res[y-1][x]!=0)&&(x+1<len&&res[y][x+1]==0)) {
				x++;continue;
			}
			if((x+1>=len||res[y][x+1]!=0)&&(y+1<len&&res[y+1][x]==0)) {
				y++;continue;
			} 
			if((y+1>=len||res[y+1][x]!=0)&&(x-1>=0&&res[y][x-1]==0)) { 
				x--;continue;
			}
			if((x-1<0||res[y][x-1]!=0)&&(y-1>=0&&res[y-1][x]==0)) {
				y--;continue;
			} 
		}
		return res;
	}
	public int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		process(0, res,0);
		return res;
	}
	public void process(int num,int[][] res,int start) {
		int len = res.length;
		if(len-2*num==0) return;
		if(len-2*num==1) {
			res[num][num] = len*len; 
			return;
		}
		for(int i=num;i<len-num;i++) {
			start++;
			res[num][i] = start;
		}
		for(int i = num+1;i<len-num-1;i++) {
			start++;
			res[i][len-1-num]=start;
		}
		for(int j = len-num-1;j>=num;j--) {
			start++;
			res[len-1-num][j] = start;
		}
		for(int i = len-num-2;i>=num+1;i--) {
			start++;
			res[i][num] = start;
		}
		process(num+1, res,start);
	}
	public static void main(String[] args) {
		work0059 w = new work0059();
		int[][] res = w.generateMatrix2(5);
		for(int i = 0;i<res.length;i++) {
			for (int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j]+",");
			}
			System.out.println();
		}
		
	}
}
