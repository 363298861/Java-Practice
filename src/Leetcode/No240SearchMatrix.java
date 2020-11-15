package Leetcode;

public class No240SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        if(matrix.length == 0) return false;
        int col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target)
                return true;
            if(target > matrix[row][col])
                row++;
            else if(target < matrix[row][col])
                col--;
        }
        return false;
    }
}
