package Leetcode;

public class No35SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        if(lo == hi){
            if(nums[lo] < target)
                return lo + 1;
        }
        return lo;
    }
}
