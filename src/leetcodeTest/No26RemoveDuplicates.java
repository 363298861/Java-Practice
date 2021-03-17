package leetcodeTest;

public class No26RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int length = 0, ptr = 0;
        while(ptr < nums.length){
            if(nums[length] == nums[ptr]){
                ptr++;
            }else{
                nums[++length] = nums[ptr];
            }
        }
        return length + 1;
    }
}
