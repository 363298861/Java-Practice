package Leetcode;

public class No122BestTimeToSellTwo {
    public int maxProfit(int[] prices) {
        int max = 0;
        int l = prices.length;
        for(int i = 0; i < l; i++){
            if(i < l - 1 && prices[i + 1] > prices[i]){
                int n = 1;
                while(i + n < l && prices[i + n] > prices[i + n - 1])
                    n++;
                max += prices[i + n - 1] - prices[i];
                i = i + n - 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        No122BestTimeToSellTwo t = new No122BestTimeToSellTwo();
        System.out.println(t.maxProfit(a));
    }
}
