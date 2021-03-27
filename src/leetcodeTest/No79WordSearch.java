package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

public class No79WordSearch {
    public boolean exist(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        char[] w = word.toCharArray();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(dfs(board, i, j, w, 0)) return true;

            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] word, int wi){
        int row = board.length, col = board[0].length;
        if(wi >= word.length) return true;
        if(i < 0 || i >= row || j < 0 || j >= col) return false;
        char tmp = board[i][j];
        if(tmp != word[wi]) return false;
        board[i][j] = '@';
        boolean exist = dfs(board, i + 1, j, word, wi + 1)
                || dfs(board, i - 1, j, word, wi + 1)
                || dfs(board, i, j + 1, word, wi + 1)
                || dfs(board, i, j - 1, word, wi +1);
        board[i][j] = tmp;
        return exist;
    }

    public static void main(String[] args) {

    }
}
