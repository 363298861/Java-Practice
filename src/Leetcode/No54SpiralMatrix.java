package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No54SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = 0;
        int rEnd = matrix.length - 1;
        if(rEnd == - 1)
            return res;
        int col = 0;
        int cEnd = matrix[0].length - 1;
        int n = 0;
        int size = 0;
        int element = (rEnd + 1) * (cEnd + 1);

        while(n < rEnd / 2 + 1) {
            // traverse right
            while (col <= cEnd - n) {
                res.add(matrix[row][col]);
                size++;
                col++;
            }
            if(size == element)
                break;
            row++;
            col--;
            //traverse right most column
            while (row <= rEnd - n) {
                res.add(matrix[row][col]);
                size++;
                row++;
            }
            if(size == element)
                break;
            col--;
            row--;
            //traverse bottom row
            while (col >= n) {
                res.add(matrix[row][col]);
                size++;
                col--;
            }
            if(size == element)
                break;
            col++;
            row--;
            //traverse left most column
            while (row > n) {
                res.add(matrix[row][col]);
                size++;
                row--;
            }
            if(size == element)
                break;
            row++;
            col++;
            n++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        No54SpiralMatrix t = new No54SpiralMatrix();
        System.out.println(t.spiralOrder(matrix));
    }
}
