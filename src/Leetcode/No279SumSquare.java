package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class No279SumSquare {
    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        for(int i = 1; i < n + 1; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j * j < i; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public int numSquaresBFS(int n){
        if(n == 0) return 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        int depth = 1;
        int t;
        int l = queue.size();
        while(true) {
            for (int i = 0; i < l; i++) {
                t = queue.poll();
                for (int j = 1; j * j <= t; j++) {
                    queue.offer(t - j * j);
                    if (t - j * j == 0) return depth;
                }
            }
            l = queue.size();
            depth++;
        }
    }

    public static void main(String[] args) {
        No279SumSquare n = new No279SumSquare();
        System.out.println(n.numSquaresBFS(12));
    }
}
