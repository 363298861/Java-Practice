package Leetcode;

public class No64MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];

        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++){
                if(i == 0 && j == 0)
                    dp[i][j] = grid[i][j];
                else if(i == 0)
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                else if(j == 0)
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                else{
                    if(dp[i - 1][j] > dp[i][j - 1])
                        dp[i][j] = dp[i][j - 1] + grid[i][j];
                    else
                        dp[i][j] = dp[i - 1][j] + grid[i][j];
                }
            }
        return dp[row - 1][col - 1];
    }

    public int modified(int[][] grid){
        int col = grid[0].length;
        int[] dp = new int[col];

        for(int[] row : grid){
            for(int i = 0; i < col; i++){
                if(i == 0)
                    dp[i] += row[0];
                else if(dp[i] == 0 || dp[i - 1] < dp[i])
                    dp[i] = dp[i - 1] + row[i];
                else
                    dp[i] += row[i];
            }
        }
        return dp[col - 1];
    }

    public static void main(String[] args) {
        int[][] t = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        No64MinimumPathSum n = new No64MinimumPathSum();
        System.out.println(n.modified(t));
    }
}
