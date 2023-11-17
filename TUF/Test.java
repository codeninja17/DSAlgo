package TUF;

import java.util.Stack;

public class Test {

    boolean finished = false;
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    public void backtrack(char[][] board, int row , int column) {
        if(column == 9) {
            row = row + 1;
            column = 0;
        }
        if(row == 9) {
            finished = true;
            return;
        }
        if(board[row][column] == '.') {
            boolean [] candidates = candidates(board, row, column);
            for(int i = 0; i < candidates.length; i++) {
                if(!candidates[i]) {
                    board[row][column] = (char) (i+1 + '0');
                    System.out.println(board[row][column]);
                    backtrack(board,row, column + 1);
                    if(finished) return;
                    board[row][column] = '.';
                }
            }
        } else {
            backtrack(board,row, column + 1);
        }
    }

    public boolean[] candidates(char[][] board, int row , int column) {

        boolean[] candidates = new boolean[9];
        int i;
        for(i = 0; i < board[row].length; i++){
            if(board[row][i] != '.'){
                candidates[(board[row][i] - '0') - 1] = true;
            }
        }

        for(i = 0; i < board.length; i++){
            if(board[i][column] != '.')
                candidates[board[i][column] - '0' - 1] = true;
        }

        int topLeftRow = (row / 3) * 3;
        int topLeftCol = (column / 3) * 3;

        for(i = topLeftRow; i < topLeftRow + 3 ; i++) {
            for(int j = topLeftCol; j < topLeftCol + 3 ; j++) {
                if(board[i][j] != '.')
                    candidates[board[i][j] - '0' - 1] = true;
            }
        }
        return candidates;
    }

    public static void main(String[] args) {
        Test test = new Test();
        char [][] b = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        test.solveSudoku(b);
    }
}
