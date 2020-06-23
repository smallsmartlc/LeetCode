package Leetcode.smart;

import java.util.HashSet;
import java.util.Set;

public class work0036 {
	public boolean isValidSudoku2(char[][] board) {

		Set<Character> set = null;
		for(int i = 0;i<board.length;i++) {
			set = new HashSet<>();
			for (int j = 0; j < board[i].length; j++) {
				if(board[i][j]!='.') {
					if(set.contains(board[i][j])) return false; 
					set.add(board[i][j]);
				}
			}
		}
		for(int i = 0;i<board.length;i++) {
			set = new HashSet<>();
			for (int j = 0; j < board[i].length; j++) {
				if(board[j][i]!='.') {
					if(set.contains(board[j][i])) return false; 
					set.add(board[j][i]);
				}
			}
		}
		int i =0 ,j = 0;
		while(i<9) {
			set = new HashSet<>();
			for(int col=i;col<i+3;col++) {
				for(int row=j;row<j+3;row++) {
					if(board[row][col]!='.') {
					if(set.contains(board[row][col])) return false; 
					set.add(board[row][col]);
				}
				}
			}
			 if(j+3!=9){
	                j=j+3;
	            //同一行相邻九宫格遍历完毕，下一行首个九宫格移动
	            }else{
	                i=i+3;
	                j=0;
	            }
		}
		return true;
    }
	
	public boolean isValidSudoku(char[][] board) {
		
		return true;
	}
	public static void main(String[] args) {
		work0036 w = new work0036();
		char[][] num1 = new char[][]{
			{'5','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'},
			};
		char[][] num2 = new char[][]{
			{'8','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'},
			};
		System.out.println(w.isValidSudoku2(num1));
	}
}
