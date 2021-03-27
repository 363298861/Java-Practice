package leetcodeTest;

public class No74SearchSortedMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        for(int i = 0; i < row; i++){
            if(matrix[i][0] == target) return true;
            else if(i == 0 && matrix[i][0] > target)
                return false;
            else if(i == row - 1 || (matrix[i][0] <= target && matrix[i + 1][0] > target)){
                for(int j = 1; j < col; j++){
                    if(matrix[i][j] == target)
                        return true;
                    else if(matrix[i][j] > target)
                        return false;
                }
            }
        }
        return false;
    }
}
