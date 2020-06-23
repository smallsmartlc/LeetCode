package Leetcode.smart;

public class LecoUtil {
	public static int[][] LecoNewNums(int m,int n,int... x){
		int index = 0;
		int[][] nums = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				nums[i][j] = x[index];
				index++;
			}
		}
		return nums;
	}
	public static char[][] LecoNewChars(int m,int n,char... x){
		int index = 0;
		char[][] nums = new char[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				nums[i][j] = x[index];
				index++;
			}
		}
		return nums;
	}
 	public static void LecoPrint(int[] nums) {
		System.out.print("{");
		for (int i : nums) {
			System.out.print(i+",");
		}
		System.out.println("}");
	}
	public static void LecoPrint(String[] nums) {
		System.out.print("{");
		for (String i : nums) {
			System.out.print(i+",");
		}
		System.out.println("}");
	}
	public static void LecoPrint(char[] nums) {
		System.out.print("{");
		for (char i : nums) {
			System.out.print(i+",");
		}
		System.out.println("}");
	}
	public static void LecoPrint(int[][] nums) {
		System.out.println("{");
		for (int[] is : nums) {
			System.out.print("{");
			for (int i : is) {
				System.out.print(i+",");
			}
			System.out.println("},");
		}
		System.out.println("}");
	}
	public static void LecoPrint(String[][] nums) {
		System.out.println("{");
		for (String[] is : nums) {
			System.out.print("{");
			for (String i : is) {
				System.out.print(i+",");
			}
			System.out.println("},");
		}
		System.out.println("}");
	}
	public static void LecoPrint(char[][] nums) {
		System.out.println("{");
		for (char[] is : nums) {
			System.out.print("{");
			for (char i : is) {
				System.out.print(i+",");
			}
			System.out.println("},");
		}
		System.out.println("}");
	}
	public int factorial(int i) {
		//½×³Ë
		if(i==0) return 1;
		int res =1;
		for(int j = i;j>0;j--) {
			res*=j;
		}
		return res;
	}
}
