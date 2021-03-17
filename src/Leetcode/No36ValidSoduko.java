package Leetcode;

public class No36ValidSoduko {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9], col = new boolean[9][9], box = new boolean[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    int n = board[i][j] - '1';
                    if(row[i][n] || col[j][n] || box[(j / 3) * 3 + (i / 3)][n])
                        return false;
                    else{
                        row[i][n] = true;
                        col[j][n] = true;
                        box[(j / 3) * 3 + (i / 3)][n] = true;
                    }
                }
            }
        }
        return true;
    }
}
