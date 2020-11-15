package Leetcode;

public class No213HouseRobberTwo {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    public int rob(int[] nums, int start, int end){
        int l = end - start;
        int[] dp = new int[l];
        dp[0] = nums[start];
        dp[1] = nums[start + 1];
        for(int i = 2; i < l; i++){
            dp[i] = Math.max(dp[i - 1] + nums[i + start] - nums[i - 1 + start], dp[i - 2] + nums[i + start]);
        }
        return Math.max(dp[l - 1], dp[l - 2]);
    }

    public static void main(String[] args) {
        int[] test = {1, 3, 1, 3, 100};
        No213HouseRobberTwo n = new No213HouseRobberTwo();
        System.out.println(n.rob(test));
    }
}
