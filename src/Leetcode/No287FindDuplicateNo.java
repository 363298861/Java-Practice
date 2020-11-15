package Leetcode;

public class No287FindDuplicateNo {
    public int findDuplicate(int[] nums) {
        int slow = nums[nums[0]], fast = nums[nums[nums[0]]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] t = {1, 3, 4, 2, 2};
        No287FindDuplicateNo n = new No287FindDuplicateNo();
        System.out.println(n.findDuplicate(t));
    }
}
