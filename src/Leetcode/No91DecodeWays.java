package Leetcode;

public class No91DecodeWays {
    public int numDecodings(String s) {
        char[] c = s.toCharArray();
        int[] dp = new int[s.length()];
        dp[0] = c[0] == '0' ? 0 : 1;
        for(int i = 1; i < c.length; i++){

            if(c[i] != '0') dp[i] += dp[i - 1];
            if(c[i - 1] != '0' && Integer.parseInt(s.substring(i - 1, i + 1)) <= 26){
                if(i < 2)
                    dp[i]++;
                else
                    dp[i] += dp[i - 2];
            }
        }
        return dp[c.length - 1];
    }
}
