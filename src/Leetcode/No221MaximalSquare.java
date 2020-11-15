package Leetcode;

public class No221MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int size = 0;
        int row = matrix.length;
        if(row == 0) return 0;
        int col = matrix[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                while(isSquare(matrix, i, j, size))
                    size++;
            }
        }
        return size * size;
    }

    private boolean isSquare(char[][] matrix, int i, int j, int size){
        int row = matrix.length;
        int col = matrix[0].length;
        if(i + size >= row || j + size >= col) return false;
        for(int m = i; m <= i + size; m++){
            for(int n = j; n <= j + size; n++){
                if(matrix[m][n] == '0')
                    return false;
            }
        }
        return true;
    }

    public int maximalSquareDP(char[][] matrix){
        int size = 0;
        int row = matrix.length;
        if(row == 0) return 0;
        int col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];
        int res = 0;
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                if(matrix[i - 1][j - 1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res * res;
    }
}










