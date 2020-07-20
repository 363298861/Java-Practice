package Leetcode;

public class No74SearchTwoDimMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row == 0) return false;
        int col = matrix[0].length;
        if(col == 0) return false;
        for(int i = 0; i < row; i++){
            if(target < matrix[i][0])
                return false;
            else if(i < row - 1 && target >= matrix[i + 1][0])
                continue;
            else {
                for (int j = 0; j < col; j++) {
                    if(matrix[i][j] == target)
                        return true;
                    else if(j < col - 1 && target < matrix[i][j + 1] && target > matrix[i][j])
                        return false;
                }
                return false;
            }
        }
        return false;
    }
}
