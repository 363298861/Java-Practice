package Leetcode;

import java.util.Arrays;

public class No136SingleNumber {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i + 1])
                i++;
            else
                return nums[i];
        }
        return nums[nums.length - 1];
    }

    public int singleNumber2(int[] nums){
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            result ^= nums[i];
        }
        return result;
    }
}
