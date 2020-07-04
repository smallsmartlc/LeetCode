package Leetcode.smart;

public class work0007 {
	public int reverse(int x) {
		int res = 0;
		while(x!=0) {
			int pop=x%10;
			x=x/10;
			if(res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10&&pop>7)) return 0 ;
			if(res<Integer.MIN_VALUE/10||(res==Integer.MIN_VALUE/10&&pop<-8)) return 0 ;
			res=res*10+pop;
		}
		return res;
	}
	
	public static void main(String[] args) {
		work0007 w = new work0007();
		System.out.println(w.reverse(214748364));
	}
}



