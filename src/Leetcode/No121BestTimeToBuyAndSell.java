package Leetcode;

public class No121BestTimeToBuyAndSell {

    public int maxProfit(int[] prices) {
        int l = prices.length;
        int[] dp = new int[l];
        int max = prices[l - 1];

        for(int i = l - 1; i >= 0; i--){
            if(max - prices[i] > 0){
                dp[i] = max - prices[i];
            }else{
                max = prices[i];
            }
        }
        int r = 0;
        for(int i = 0; i < dp.length; i++){
            if(dp[i] > r)
                r = dp[i];
        }
        return r;
    }

    public static void main(String[] args) {
        No121BestTimeToBuyAndSell t = new No121BestTimeToBuyAndSell();
        int[] a = {7,6,4,3,1};
        System.out.println(t.maxProfit(a));
    }
}
