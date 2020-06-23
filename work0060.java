package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;

/**

 */
public class work0060 {
	public int ex(int i) {
		if(i==0) return 1;
		int res =1;
		for(int j = i;j>0;j--) {
			res*=j;
		}
		return res;
	}
	public String getPermutation(int n, int k) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
        String res = "";
		for (int i = n-1; i >= 0; i--) {
			int temp = 0;
			while(k>ex(i)&&i!=0) {
				k=k-ex(i);
				temp++;
			}
			res += list.get(temp);
			list.remove(temp);
		}
		
		return res;
    }
	public static void main(String[] args) {
		work0060 w = new work0060();
		System.out.println(w.ex(4));
		System.out.println(w.getPermutation(4, 4));
	}
}
