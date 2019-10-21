package Leetcode;

public class No26RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] != nums[i + 1]){
                res++;
                nums[res] = nums[res - 1] + 1;
            }
        }
        return res + 1;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 1, 2, 2, 3, 3, 3, 4};
        No26RemoveDuplicates n = new No26RemoveDuplicates();
        System.out.println(n.removeDuplicates(a1));
    }
}
