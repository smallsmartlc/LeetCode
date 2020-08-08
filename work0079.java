package Leetcode.smart;


public class work0079 {
	int row;
	int col;
	public boolean exist(char[][] board, String word) {
		if (board.length<1||board[0].length<1) return false;
		char[] words = word.toCharArray();
		int n = board.length;
		int m = board[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(board[i][j]!=words[0]) continue;
				int index = 1;
				row = i;
				col = j;
				if(isNear(board, words,1)) {
					return true;
				}
			}
		}
		return false;
    }
	
	private boolean isNear(char[][] board,char[] words,int index) {
		if(index>=words.length) return true;
		if(row>0&&board[row-1][col]==words[index]) {
			char temp = board[row][col];
			board[row][col] = '*';
			row--;
			if(isNear(board, words, index+1)) return true;
			row++;
			board[row][col] = temp;
		}
		if(row<board.length-1&&board[row+1][col]==words[index])  {
			char temp = board[row][col];
			board[row][col] = '*';
			row++;
			if(isNear(board, words, index+1)) return true;
			row--;
			board[row][col] = temp;
		}
		if(col>0&&board[row][col-1]==words[index])  {
			char temp = board[row][col];
			board[row][col] = '*';
			col--;
			if(isNear(board, words, index+1)) return true;
			col++;
			board[row][col] = temp;
		}
		if(col<board[0].length-1&&board[row][col+1]==words[index])  {
			char temp = board[row][col];
			board[row][col] = '*';
			col++;
			if(isNear(board, words, index+1)) return true;
			col--;
			board[row][col] = temp;
		}
		return false;
	}
	
	public static void main(String[] args) {
		work0079 w = new work0079();
		char[][] board = LecoUtil.LecoNewChars(4, 3, 'A', 'B', 'C', 'E', 'S', 'F', 'C', 'S', 'A', 'D', 'E', 'E');
		LecoUtil.LecoPrint(board);
		System.out.println(w.exist(board, "ABCB"));
	}
}
