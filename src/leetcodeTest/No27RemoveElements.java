package leetcodeTest;

public class No27RemoveElements {
    public int removeElement(int[] nums, int val) {
        int len = 0, ptr = 0;
        while(ptr < nums.length){
            while(ptr < nums.length && nums[ptr] == val)
                ptr++;
            if(ptr == nums.length)
                return len;
            nums[len++] = nums[ptr++];
        }
        return len;
    }
}
