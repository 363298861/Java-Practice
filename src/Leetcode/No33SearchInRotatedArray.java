package Leetcode;

public class No33SearchInRotatedArray {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] > nums[hi])
                lo = mid + 1;
            else
                hi = mid;
        }
        int pivot = lo;
        lo = 0; hi = nums.length - 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            int realmid = (pivot + mid) % nums.length;
            if(nums[realmid] == target) return realmid;
            else if(nums[realmid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] test = {3, 4, 5, -1, 0, 1, 2};
        No33SearchInRotatedArray n = new No33SearchInRotatedArray();
        System.out.println(n.search(test, 3));
    }
}

//