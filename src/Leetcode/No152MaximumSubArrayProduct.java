package Leetcode;

public class No152MaximumSubArrayProduct {
    public int maxProduct(int[] nums) {
        int res = nums[0], max = nums[0], min = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0) {
                max = max + min;
                min = max - min;
                max = max - min;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);

            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, -2, 3, 0, 4};
        No152MaximumSubArrayProduct n = new No152MaximumSubArrayProduct();
        System.out.println(n.maxProduct(nums));
    }
}
