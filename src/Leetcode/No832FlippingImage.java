package Leetcode;

public class No832FlippingImage {
    public int[][] flipAndInvertImage(int[][] A) {
        int row = A.length;
        if(row == 0) return A;
        int col = A[0].length;
        int tmp;
        for(int i = 0; i < row; i++){
            if(col % 2 == 1) A[i][col / 2] = 1 - A[i][col / 2];
            for(int j = 0; j < col / 2; j++){
                tmp = A[i][j];
                A[i][j] = 1 - A[i][col - 1 - j];
                A[i][col - 1 - j] = 1 - tmp;
            }
        }
        return A;
    }
}
