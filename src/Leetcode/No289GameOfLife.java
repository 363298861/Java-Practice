package Leetcode;

public class No289GameOfLife {
    public void gameOfLife(int[][] board) {
        int row = board.length;
        if(row == 0) return;
        int col = board[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int neigh = neighbours(board, i, j);
                if(board[i][j] == 0 && neigh == 3){
                    board[i][j] |= 2;
                }else if(board[i][j] == 1){
                    if(neigh == 2 || neigh == 3){
                        board[i][j] |= 2;
                    }
                }
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++)
                board[i][j] >>= 1;
        }
    }

    private int neighbours(int[][] board, int row, int col){
        int neighbours = 0;
        for(int i = -1; i < 2; i++){
            for(int j = -1; j < 2; j++){
                if(row + i >= 0 && row + i < board.length && col + j >= 0 && col + j < board[0].length){
                    neighbours += board[row + i][col + j] & 1;
                }
            }
        }
        return neighbours - board[row][col];
    }

    public static void main(String[] args) {
        int[][] test = {{0,1,0}, {0,0,1}, {0,0,0}};
        No289GameOfLife n = new No289GameOfLife();
        System.out.println(n.neighbours(test, 0, 1));
    }
}
