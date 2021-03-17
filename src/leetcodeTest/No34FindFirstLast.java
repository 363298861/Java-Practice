package leetcodeTest;

public class No34FindFirstLast {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int lo = 0, hi = nums.length - 1;
        res[0] = -1; res[1] = -1;
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] < target){
                lo = mid + 1;
            }else if(nums[mid] > target)
                hi = mid - 1;
            else{
                if(mid == 0 || nums[mid - 1] != nums[mid]){
                    res[0] = mid;
                    break;
                }else{
                    hi--;
                }
            }
        }

        lo = 0;
        hi = nums.length - 1;
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] < target){
                lo = mid + 1;
            }else if(nums[mid] > target)
                hi = mid - 1;
            else{
                if(mid == nums.length - 1 || nums[mid + 1] != nums[mid]){
                    res[1] = mid;
                    break;
                }else{
                    lo++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        No34FindFirstLast n = new No34FindFirstLast();
        int[] test = {5,7,7,8,8,10};
        System.out.println(n.searchRange(test, 8)[0]);
        System.out.println(n.searchRange(test, 8)[1]);
    }
}
