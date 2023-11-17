package questions.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQuuens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean [][] placed = new boolean[n][n];
        backtrack(n,0, placed, res);
        return res;

    }

    public void backtrack(int n, int row, boolean [][] placed, List<List<String>> res) {
        if(row == n) {
            processSolution(placed,res);
            return;
        }

        List<Integer> candidateColumns = generateCandidates(placed, row);

        for(int column : candidateColumns) {
            placed[row][column] = true;
            backtrack(n, row + 1, placed, res);
            placed[row][column] = false;
        }
    }

    private List<Integer> generateCandidates(boolean [][] placed, int row) {
        List<Integer> candidateIndices = new ArrayList<>();
        for(int i = 0 ; i  < placed.length; i++) {

            int column = i - 1;
            int r = row - 1;
            boolean isSafe = true;
            for(int j = 0 ; j <= row; j++) {
                if(placed[j][i])  {
                    isSafe = false;
                    break;
                }
            }

            while (isSafe && column >=0  && r >=0 ){
                if(placed[r][column]) {
                    isSafe = false;
                    break;
                }
                column--;
                r--;
            }

            r = row;
            column = i;
            while (isSafe && column < placed.length  && r >=0 ){
                if(placed[r][column]) {
                    isSafe = false;
                    break;
                }
                column++;
                r--;
            }


            if(isSafe)
                candidateIndices.add(i);
        }
        return candidateIndices;
    }

    private void processSolution(boolean[][] placed, List<List<String>> res) {
        List<String> strings = new ArrayList<>();
        for(int i = 0 ; i < placed.length; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < placed[i].length; j++) {
                if (placed[i][j]) {
                    str.append("Q");
                } else {
                    str.append(".");
                }
            }
            strings.add(str.toString());
        }
        res.add(strings);
    }

    public static void main(String[] args) {
        NQuuens nQuuens = new NQuuens();
        System.out.println(nQuuens.solveNQueens(4));
    }
}
