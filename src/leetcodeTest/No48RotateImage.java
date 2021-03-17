package leetcodeTest;

public class No48RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int j = 0; j < n / 2; j++){
            for(int i = j; i < n - 1 - j; i++){
                int tr = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = matrix[j][i];
                int br = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = tr;
                matrix[j][i] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = br;
            }
        }
    }
}
