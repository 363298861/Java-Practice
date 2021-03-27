package Leetcode;

public class No97InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        int l1 = c1.length, l2 = c2.length, l3 = c3.length;
        if(l1 + l2 != l3) return false;
        boolean[][] dp = new boolean[l2 + 1][l1 + 1];
        dp[0][0] = true;
        for(int i = 1; i <= l1; i++){
            dp[0][i] = (c1[i - 1] == c3[i - 1]) && dp[0][i - 1];
        }
        for(int j = 1; j <= l2; j++){
            dp[j][0] = (c2[j - 1] == c3[j - 1]) && dp[j - 1][0];
        }
        for(int i = 1; i <= l2; i++){
            for(int j = 1; j <= l1; j++){
                dp[i][j] = (dp[i - 1][j] && c2[i - 1] == c3[i + j - 1]) || (dp[i][j - 1] && c1[j - 1] == c3[i + j - 1]);

            }
        }
        for(int i = 0; i <= l2; i++){
            for(int j = 0; j <= l1; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[l2][l1];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        String ss1 = "db";
        String ss2 = "b";
        String ss3 = "cbb";
        No97InterleavingString n = new No97InterleavingString();
        n.isInterleave(ss1, ss2, ss3);
    }
}
