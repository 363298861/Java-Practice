package leetcodeTest;

public class No59SpiralMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int m = 1;
        int up = 0, left = 0, right = n - 1, down = n - 1;
        while(m <= n * n){
            for(int i = left; i <= right; i++){
                res[up][i] = m++;
            }
            up++;
            for(int i = up; i <= down; i++){
                res[i][right] = m++;
            }
            right--;
            for(int i = right; i >= left; i--){
                res[down][i] = m++;
            }
            down--;
            for(int i = down; i >= up; i--){
                res[i][left] = m++;
            }
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        No59SpiralMatrix n = new No59SpiralMatrix();
        int[][] res = n.generateMatrix(3);
        for(int[] row : res){
            for(int i : row)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
