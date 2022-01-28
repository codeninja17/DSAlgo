package algorithms.backtracking;

import java.util.Arrays;

public class TwoDQueenCombination {

    public void getAll2DQueenCombination(boolean [] [] board , int row , int col , int qpsf , int tq , String ans){

        if(row == board.length){
            return;
        }

        if(col == board[0].length){
            col = 0;
            row = row+1;
        }

        if(qpsf == tq){
            System.out.println(ans);
            return;
        }

        getAll2DQueenCombination(board,row,col+1,qpsf+1,tq,ans+"("+row+","+col+") ");
        getAll2DQueenCombination(board,row,col+1,qpsf,tq,ans);

    }

    public static void main(String[] args) {
        boolean [][] booleans = new boolean[3][2];
        for(boolean[] arr : booleans){
            Arrays.fill(arr, false);
        }
        TwoDQueenCombination twoDQueenCombination = new TwoDQueenCombination();
        twoDQueenCombination.getAll2DQueenCombination(booleans,0,0,0,2,"");
    }

}
