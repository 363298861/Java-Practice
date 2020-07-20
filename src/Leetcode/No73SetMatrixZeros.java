package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No73SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for(int i : row)
            matrix[i] = new int[matrix[0].length];
        for(int i : col) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = 0;
            }
        }
    }

    //O(1) using constant space
    public void setZerosModified(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int col0 = 1;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
            }
        }
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            if(col0 == 0) matrix[i][0] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] test = {{0, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        No73SetMatrixZeros n = new No73SetMatrixZeros();
        n.setZerosModified(test);
        for(int i = 0; i < test.length; i++){
            for(int j = 0; j < test[0].length; j++)
                System.out.print(test[i][j] + " ");
            System.out.println();
        }
    }
}
