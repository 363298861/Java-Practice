package Leetcode;

public class No59SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] res =new int[n][n];
        int r = 0;
        int t = 1;
        int nsquare = n * n + 1;
        while(r < (n + 1) / 2){
            //fill upper row
            for(int i = r; i < n - r; i++){
                res[r][i] = t++;
            }
            if(t == nsquare) return res;
            //fill right column
            for(int i = r + 1; i < n - r; i++){
                res[i][n - r - 1] = t++;
            }
            if(t == nsquare) return res;
            //fill up bottom row
            for(int i = n - r - 2; i >= r; i--){
                res[n - r - 1][i] = t++;
            }
            if(t == nsquare) return res;
            //fill up left col
            for(int i = n - r - 2; i > r; i--)
                res[i][r] = t++;
            if(t == nsquare) return res;
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        No59SpiralMatrix2 t = new No59SpiralMatrix2();
        int[][] res = t.generateMatrix(5);
        for(int[] row : res) {
            for (int i : row)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
