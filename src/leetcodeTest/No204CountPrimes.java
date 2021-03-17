package leetcodeTest;

public class No204CountPrimes {
    public int countPrimes(int n) {
        boolean[] dp = new boolean[n];
        int res = 0;
        for(int i = 2; i < Math.sqrt(n); i++){
            if(!dp[i]){
                res++;
                for(int j = 2; j * i < n; j++){
                    dp[i * j] = true;
                }
            }
        }
        return res;
    }
}
