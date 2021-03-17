package Leetcode;

public class No198HouseRobber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                dp[i] = nums[i];
            }else if(i == 1){
                dp[i] = nums[i] > dp[0] ? nums[i] : dp[0];
            }else{
                dp[i] = nums[i] + dp[i - 2] > dp[i - 1] ? nums[i] + dp[i - 2] : dp[i - 1];
            }
        }
        return dp[nums.length - 1];
    }
}
