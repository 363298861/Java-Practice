package Leetcode;

public class No70ClimbingStairs {
    public int climbStairs(int n) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int dynamic(int n){
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public int lessSpace(int n){
        int first = 1;
        int second = 2;
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        for(int i = 2; i <= n; i++){
            int temp = first;
            first = second;
            second = temp + second;
        }
        return first;
    }

    public static void main(String[] args) {
        No70ClimbingStairs t = new No70ClimbingStairs();
        int r = t.lessSpace(9);
        System.out.println(r);
    }
}
