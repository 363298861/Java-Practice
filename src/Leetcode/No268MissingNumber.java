package Leetcode;

public class No268MissingNumber {
    public int missingNumber(int[] nums) {
        int l = nums.length;
        int sum = 0;
        while(l > 0){
            sum += l--;
        }
        for(int i = 0; i < nums.length; i++){
            sum -= nums[i];
        }
        return sum;
    }
}
