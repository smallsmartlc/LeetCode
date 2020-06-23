package Leetcode.smart;


public class work0130 {
	public void solve(char[][] board) {
		int row = board.length;
		if(row==0) return;
		int col = board[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(i==0||i==row-1||j==0||j==col-1) {
					changeO(board, i, j);
				}
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(board[i][j]=='O') board[i][j] = 'X';
				if(board[i][j]=='-') board[i][j] = 'O';
			}
		}
    }
	public void changeO(char[][] board,int i,int j) {
		if(board[i][j]=='O') {
			board[i][j] = '-';
			if(i>0) changeO(board, i-1, j);
			if(i<board.length-1) changeO(board, i+1, j);
			if(j>0) changeO(board, i, j-1);
			if(j<board[0].length-1) changeO(board, i, j+1);
		}
	} 
	public static void main(String[] args) {
		work0130 w= new work0130();
		char[][] board = LecoUtil.LecoNewChars(6, 4, 
				'X','O','X','O','X','O','O','X','O','X','O','X','X','O','X','O','X','O','O','X','O','X','O','X');
		w.solve(board);
		LecoUtil.LecoPrint(board);
	}
}
