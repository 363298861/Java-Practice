package Leetcode;

import java.util.List;
import java.util.Map;

public class No37SudokuSolver {
    boolean[][] row, col, box;
    public void solveSudoku(char[][] board) {
        row = new boolean[9][9];
        col = new boolean[9][9];
        box = new boolean[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    int t = board[i][j] - '1';
                    row[i][t] = true;
                    col[j][t] = true;
                    box[(j / 3) * 3 + (i / 3)][t] = true;
                }
            }
        }
        dfs(board);
    }

    public boolean dfs(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(int k = 0; k < 9; k++){
                        if(!row[i][k] && !col[j][k] && !box[(j / 3) * 3 + (i / 3)][k]){
                            board[i][j] = (char) (k + '1');
                            row[i][k] = true;
                            col[j][k] = true;
                            box[(j / 3) * 3 + (i / 3)][k] = true;
                            if(dfs(board))
                                return true;
                            else{
                                board[i][j] = '.';
                                row[i][k] = false;
                                col[j][k] = false;
                                box[(j / 3) * 3 + (i / 3)][k] = false;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
