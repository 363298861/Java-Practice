package Leetcode;

public class No62UniquePath {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 1;
                else{
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        No62UniquePath t = new No62UniquePath();
        System.out.println(t.uniquePaths(7, 3));
    }
}
