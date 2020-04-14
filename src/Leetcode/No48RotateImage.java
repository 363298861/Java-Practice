package Leetcode;

public class No48RotateImage {
    public void rotate(int[][] matrix) {

        int l = matrix.length;
        for(int i = 0; i < l / 2; i++){
            int[] tmp = matrix[i];
            matrix[i] = matrix[l - 1 - i];
            matrix[l - 1 -i] = tmp;
        }

        for (int i = 0; i < l; i++){
            for(int j = i + 1; j < l; j++){
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }
}
