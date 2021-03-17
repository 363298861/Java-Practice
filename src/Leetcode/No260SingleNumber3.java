package Leetcode;

public class No260SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int sub = 0;
        for(int i = 0; i < nums.length; i++){
            sub ^= nums[i];
        }
        sub &= -sub;
        for(int i = 0; i < nums.length; i++){
            if((sub & nums[i]) == 0)
                res[0] ^= nums[i];
            else
                res[1] ^= nums[i];
        }
        return res;
    }
}
