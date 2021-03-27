package leetcodeTest;

public class No80RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int slow = 2, fast = 2, ofast = nums[0];
        for(; fast < nums.length; slow++, fast++){
            if(nums[fast] == ofast){
                while(fast < nums.length && nums[fast] == nums[fast - 1])
                    fast++;
                if(fast == nums.length)
                    return slow + 1;
            }
            ofast = nums[fast - 1];
            nums[slow] = nums[fast];
        }
        return slow + 1;
    }

    public int removeDuplicates2(int[] nums){
        int i = 0;
        for(int n : nums){
            if(i < 2 || n > nums[i - 2])
                nums[i++] = n;
        }
        return i;
    }
}
