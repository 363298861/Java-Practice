package Leetcode;

public class No153FindMinRotatedSortedArray {
    public int findMin(int[] nums) {
        int first = 0, last = nums.length - 1;

        while(first < last){
            if(nums[first] < nums[last]){
                return nums[first];
            }
            int mid = (first + last) / 2;
            if(nums[first] < nums[mid]){
                first = mid + 1;
            }else if(nums[first] > nums[mid]){
                last = mid;
            }else return nums[first];
        }
        return nums[first];
    }

    public static void main(String[] args) {
        int[] test = {30, 40, 50, 10, 20, 25};
        No153FindMinRotatedSortedArray n = new No153FindMinRotatedSortedArray();
        System.out.println(n.findMin(test));
    }
}
