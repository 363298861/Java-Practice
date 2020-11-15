package Leetcode;

public class No209MinimumSizeSubArray {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int sum = nums[i];
            int j = 1;
            while(sum < s && i + j < nums.length && j < min){
                sum += nums[i + j];
                j++;
            }
            if(sum >= s) min = j;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLenModified(int s, int[] nums){
        int sum = 0;
        int start = 0, end = 0, min = Integer.MAX_VALUE;
        while(end < nums.length){
            sum += nums[end];
            end++;
            while(sum >= s){
                if(end - start < min) min = end - start;
                sum -= nums[start];
                start++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4, 5};
        No209MinimumSizeSubArray n = new No209MinimumSizeSubArray();
        System.out.println(n.minSubArrayLenModified(11, t));
    }
}
