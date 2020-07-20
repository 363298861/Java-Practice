package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class No79WordSearch {
    boolean res = false;

    public boolean exist(char[][] board, String word) {

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    backtrack(board, word.substring(1), i, j);
                }
            }
        }
        return res;
    }

    public void backtrack(char[][] board, String word, int row, int col){
        int m = board.length;
        int n = board[0].length;
        if(word.isEmpty()) {
            this.res = true;
            return;
        }
        board[row][col] ^= 256;
        if(!res && row > 0 && board[row - 1][col] == word.charAt(0)) {
            backtrack(board, word.substring(1), row - 1, col);
        }
        if(!res && row < m - 1 && board[row + 1][col] == word.charAt(0)){
            backtrack(board, word.substring(1), row + 1, col);
        }

        if(!res && col > 0 && board[row][col - 1] == word.charAt(0)){
            backtrack(board, word.substring(1), row, col - 1);
        }

        if(!res && col < n - 1 && board[row][col + 1] == word.charAt(0))
            backtrack(board, word.substring(1), row, col + 1);

        board[row][col] ^= 256;
    }

    public boolean exist2(char[][] board, String word) {

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(exist2(board, word, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist2(char[][] board, String word, int row, int col){
        if(word.isEmpty())
            return true;
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(0))
            return false;
        board[row][col] ^= 256;

        boolean exist = exist2(board, word.substring(1), row + 1, col) ||
                exist2(board, word.substring(1), row - 1, col) ||
                exist2(board, word.substring(1), row, col + 1) ||
                exist2(board, word.substring(1), row, col - 1);
        board[row][col] ^= 256;
        return exist;
    }

    public static void main(String[] args) {
        No79WordSearch w = new No79WordSearch();
        char[][] t = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(w.exist2(t, "ABCB"));
    }
}
