package leetcodeTest;

public class No96UniqueTreeStructure {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i] += (dp[j - 1] * dp[i - j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        No96UniqueTreeStructure n = new No96UniqueTreeStructure();
        System.out.println(n.numTrees(5));
    }
}
