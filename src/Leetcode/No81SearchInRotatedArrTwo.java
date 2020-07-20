package Leetcode;

import java.lang.instrument.IllegalClassFormatException;

public class No81SearchInRotatedArrTwo {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        int l = 0, r = nums.length - 1;
        while(l < r){
            int m = (l + r) / 2;
            if (nums[m] == target) return true;
            else if(nums[m] > nums[l]){
                if(nums[l] <= target && target < nums[m]){
                    r = m - 1;
                }else{
                    l = m + 1;
                }
            }else if(nums[m] < nums[r]){
                if(nums[m] < target && nums[r] >= target){
                    l = m + 1;
                }else{
                    r = m - 1;
                }
            }else{
                if(nums[l] == nums[m]) l++;
                if(nums[m] == nums[r]) r--;
            }
        }
        return nums[l] == target;
    }

    public boolean binarysearch(int[] nums, int target){
        int r = nums.length, l = 0;
        while(l <= r){
            int m = (l + r) / 2;
            if(nums[m] < target){
                l = m + 1;
            }else if(nums[m] > target){
                r = m - 1;
            }else
                return true;
        }
        return false;
    }
}
