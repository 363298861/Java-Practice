package leetcodeTest;

public class No81SearchInRotatedArray {
    public boolean search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] == target)
                return true;
            else if(nums[lo] == nums[mid] && nums[mid] == nums[hi]){
                lo++; hi--;
            }else if(nums[lo] <= nums[mid]){
                if(nums[lo] <= target && nums[mid] > target)
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }else{
                if(nums[hi] >= target && nums[mid] < target)
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        No81SearchInRotatedArray n = new No81SearchInRotatedArray();
        System.out.println(n.search(nums, 2));

    }
}
