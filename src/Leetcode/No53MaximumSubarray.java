package Leetcode;

public class No53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        double sum = Double.NEGATIVE_INFINITY;
        for(int i = 0; i < nums.length; i++){
            int temp = 0;
            for(int j = i; j < nums.length; j++){
                temp += nums[j];
                if (temp > sum)
                    sum = temp;
            }
        }
        return (int)sum;
    }

    public int dynamicProgramming(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        No53MaximumSubarray t = new No53MaximumSubarray();
        int res = t.dynamicProgramming(a);
        System.out.println(res);
    }
}
