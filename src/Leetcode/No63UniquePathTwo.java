package Leetcode;

public class No63UniquePathTwo {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1)
            return 0;
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[][] dp = new int[rows][cols];
        dp[0][0] = 1;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(i == 0 && j != 0){
                    if(obstacleGrid[i][j] == 0){
                        dp[i][j] = dp[i][j - 1];
                    }
                }else if( j == 0 && i != 0){
                    if(obstacleGrid[i][j] == 0)
                        dp[i][j] = dp[i - 1][j];
                }else if(i != 0 && j != 0){
                    if(obstacleGrid[i][j] == 0){
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }

    public int modified(int[][] obstacleGrid){

        int cols = obstacleGrid[0].length;
        int[] dp = new int[cols];
        dp[0] = 1;
        for(int[] row : obstacleGrid){
            for(int i = 0; i < cols; i++){
                if(row[i] == 1)
                    dp[i] = 0;
                else if(i > 0)
                    dp[i] += dp[i - 1];
            }
        }
        return dp[cols - 1];
    }

    public static void main(String[] args) {
        No63UniquePathTwo t = new No63UniquePathTwo();
        int[][] a = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(t.modified(a));
    }
}
