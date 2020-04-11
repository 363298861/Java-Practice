package Leetcode;

public class No75SortColors {
    //This approach is done by two-pass iteration
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                red++;
            else if(nums[i] == 1)
                white++;
            else
                blue++;
        }

        for(int i = 0; i < nums.length; i++){
            if(i < red){
                nums[i] = 0;
            }else if(i < red + white)
                nums[i] = 1;
            else
                nums[i] = 2;
        }
    }
    //This approach is done by one-pass
    public void sortColors2(int[] nums){
        int low = 0, hi = nums.length - 1;
        for(int i = 0; i <= hi; i++){
            if(nums[i] == 0){
                int tmp = nums[low];
                nums[low] = 0;
                nums[i] = tmp;
                low++;
            }else if(nums[i] == 2){
                int tmp = nums[hi];
                nums[hi] = 2;
                nums[i] = tmp;
                i--;hi--;
            }
        }
    }
}
