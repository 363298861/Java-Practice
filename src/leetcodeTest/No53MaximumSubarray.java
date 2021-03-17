package leetcodeTest;

public class No53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = nums[i] > nums[i] + dp[i - 1] ? nums[i] : nums[i] + dp[i - 1];
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
