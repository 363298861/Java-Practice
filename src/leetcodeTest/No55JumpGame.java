package leetcodeTest;

public class No55JumpGame {
    public boolean canJump(int[] nums) {
        int lo = 0, hi = 0;
        int loprev = 0, hiprev = 0;
        while(hi < nums.length - 1) {
            loprev = lo;
            hiprev = hi;
            for (int i = loprev; i <= hiprev; i++) {
                if(nums[i] == 0)
                    continue;
                lo = i + 1;
                hi = Math.max(hi, nums[i] + i);
            }
            if(hi == hiprev && hi < nums.length - 1)
                return false;
        }
        return true;
    }
}
