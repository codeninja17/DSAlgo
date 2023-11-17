package questions.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 79. Word Search
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word == null || word.isEmpty()) {
            return false;
        }
        boolean [] [] visited = new boolean[board.length][board[0].length];
        for(int i = 0 ; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(0, i, j, word, visited, board ))
                    return true;
            }
        }
        return false;
    }

    private boolean backtrack(int currentIndex, int row, int column, String word, boolean[][] visited, char [][] board) {
        if(currentIndex == word.length() - 1 && word.charAt(currentIndex) == board[row][column]) {
            return true;
        }

        if(word.charAt(currentIndex) != board[row][column]) {
            return false;
        }

        List<List<Integer>> candidates = getAdjancentCandidates(row, column, board, visited);

        for (List<Integer> candidate :  candidates) {
            visited[row][column] = true;
            if(backtrack(currentIndex+1, candidate.get(0), candidate.get(1), word, visited, board)) {
                return true;
            }
            visited[row][column] = false;
        }
        return false;
    }

    private List<List<Integer>> getAdjancentCandidates(int row, int column, char[][] board, boolean [][] visited) {
        List<List<Integer>> candidates = new ArrayList<>();
        int [][] adjacentElements = {{-1,0}, {0,-1}, {1,0} , {0,1}};
        for (int [] elem : adjacentElements) {
            int nextRow = row + elem[0];
            int nextCol = column + elem[1];
            if (nextRow < 0 || nextRow == board.length || nextCol < 0 || nextCol == board[0].length
                    || visited[nextRow][nextCol]) {
                continue;
            }
            List<Integer> candidate = new ArrayList<>();
            candidate.add(nextRow);
            candidate.add(nextCol);
            candidates.add(candidate);
        }
        return candidates;
    }

    public static void main(String[] args) {
        char [][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String s = "ABCCED";
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board, s));
    }

}
