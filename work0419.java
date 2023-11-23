package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode0419 甲板上的战舰
 */

public class work0419 {

    public int countBattleships(char[][] board) {
        int res = 0;
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                if(board[i][j] == '.') continue;
                if((i == 0 || board[i-1][j] == '.') && (j == 0 || board[i][j-1] == '.') ) res++;
            }
        }
        return res;
    }

    public int countBattleships1(char[][] board) {
        int res = 0;
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                if(board[i][j] == '.') continue;
                board[i][j] = '.';
                for (int k = i + 1; k < board.length && board[k][j] == 'X';k++){
                    board[k][j] = '.';
                }
                for (int k = j + 1; k < board[0].length && board[i][k] == 'X';k++){
                    board[i][k] = '.';
                }
                res++;
            }
        }
        return res;
    }

    public int countBattleships0(char[][] board) {
        int res = 0;
        for(int i =   0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                if(board[i][j] == '.') continue;
                res++;
                search(board,i,j);
            }
        }
        return res;
    }

    private void search(char[][] board,int i,int j){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if (board[i][j] == '.') return;
        board[i][j] = '.';
        search(board,i+1,j);
        search(board,i-1,j);
        search(board,i,j+1);
        search(board,i,j-1);
    }
}