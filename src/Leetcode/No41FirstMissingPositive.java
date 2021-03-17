package Leetcode;

public class No41FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int l = nums.length;
        for(int i = 0; i < l; i++){
            if(nums[i] > 0 && nums[i] <= l){
                if(nums[i] != i + 1){
                    int tmp = nums[i];
                    nums[i] = nums[tmp - 1];
                    nums[tmp - 1] = tmp;
                    if(tmp != nums[i])
                        i--;
                }
            }
        }
        for(int i = 0; i < l; i++){
            if(nums[i] != i + 1)
                return i + 1;
        }
        return l + 1;
    }
}
