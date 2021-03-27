package leetcodeTest;

public class No73SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        boolean col0 = false, row0 = false;
        for(int i = 0; i < row; i++){
            if(matrix[i][0] == 0) col0 = true;
            for(int j = 1; j < col; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int j = 1; j < col; j++){
            if(matrix[0][j] == 0){
                for(int i = 0; i < row; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i = 0; i < row; i++){
            if(matrix[i][0] == 0){
                for(int j = 1; j < col; j++)
                    matrix[i][j] = 0;
            }else if(col0)
                matrix[i][0] = 0;
        }
    }
}
