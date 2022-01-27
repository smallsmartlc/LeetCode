package Leetcode.smart;

//348. 设计井字棋 lintcode746


public class work0348 {

    public static void main(String[] args) throws AlreadyTakenException, GameEndException {
        TicTacToe t = new TicTacToe();
        t.move(0, 0); // X 的回合
        t.move(1, 0); // O 的回合
        t.move(1, 1); // X 的回合
        t.move(2, 0); // O 的回合
        t.move(2, 2); // X 的回合并获得胜利
        t.move(0, 0);  //抛出 GameEndException
        t.move(0, 0); // X 的回合
        t.move(0, 0); // 抛出 AlreadyTakenException
        t.move(1, 0); // O 的回合
        t.move(1, 1); // X 的回合
        t.move(2, 0); // o 的回合
        t.move(2, 2); // X 的回合并获得胜利
    }

    private static class TicTacToe {
        /**
         * Initialize your data structure here.
         */
        private boolean status;
        private Boolean[][] board;
        private boolean now;
        private int nums;


        public TicTacToe() {
            board = new Boolean[3][3];
            status = true;
            now = true;
            nums = 0;
        }

        public boolean move(int row, int col) throws AlreadyTakenException, GameEndException {
            if (!status) {
                throw new GameEndException();
            }
            if (board[row][col] != null) {
                throw new AlreadyTakenException();
            }
            board[row][col] = now;
            nums++;
            if(nums >= 9) {
                status = false;
                System.out.println("it's a draw");
            }
            now = !now;
            if (checkWin(row, col)) {
                status = false;
                return true;
            }
            return false;
        }

        private boolean checkWin(int row, int col) {
            Boolean flag = board[row][col];
            boolean res = true;
            for (int i = 0; i < 3; i++) {
                if (board[row][i] == null || !board[row][i].equals(flag)) {
                    res = false;
                    break;
                }
            }
            if (res == true) return true;
            res = true;
            for (int i = 0; i < 3; i++) {
                if (board[i][col] == null || !board[i][col].equals(flag)) {
                    res = false;
                    break;
                }
            }
            if (res == true) return true;
            if (col == row) {
                res = true;
                for (int i = 0; i < 3; i++) {
                    if (board[i][i] == null || !board[i][i].equals(flag)) {
                        res = false;
                        break;
                    }
                }
                if (res == true) return true;
            }
            if (col + row == 2) {
                res = true;
                for (int i = 0; i < 3; i++) {
                    if (board[i][2 - i] == null || !board[i][2 - i].equals(flag)) {
                        res = false;
                        break;
                    }
                }
                if (res == true) return true;
            }
            return false;
        }
    }
}

class AlreadyTakenException extends Exception {
    public AlreadyTakenException() {
        super("This place has been taken");
    }
}

class GameEndException extends Exception {
    public GameEndException() {
        super("Game has been ended, cannot make any more moves");
    }
}