package Leetcode;

public class No189RotateArray {
    public void rotate(int[] nums, int k) {
        if(k == 0) return;
        int last = nums[nums.length - 1];
        for(int i = nums.length - 1; i > 0; i--){
            nums[i] = nums[i - 1];
        }
        nums[0] = last;
        rotate(nums, k - 1);
    }

    public void rotateModified(int[] nums, int k){
        k %= nums.length;
        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, nums.length - 1);
    }

    public void rotate(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] =  temp;
            start++;
            end--;
        }
    }
}
