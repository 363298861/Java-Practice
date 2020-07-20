package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No55JumpGame {
    public boolean canJump(int[] nums) {
        if(nums.length == 1 || nums.length - 1 <= nums[0])
            return true;
        boolean res = false;
        int i = 1;
        while(i <= nums[0]){
            int[] tmp = Arrays.copyOfRange(nums, i, nums.length);
            res = res || canJump(tmp);
            i++;
        }
        return res;
    }

    public boolean canJump2(int[] nums){
        if(nums.length == 1)
            return true;
        List<Integer> res = new ArrayList<>();
        int l = nums.length;
        for(int i = 1; i <= nums[0]; i++){
            res.add(i);
        }
        while(!res.isEmpty()){
            int t = res.remove(0);
            if(t >= l - 1) return true;
            for(int i = 1; i <= nums[t]; i++) {
                if(!res.contains(t + i))
                    res.add(t + i);
            }
        }
        return false;
    }

    public boolean canJump3(int[] nums){
        int l = nums.length - 1;
        int max = 0;
        for(int i = 0; i < l; i++){
            if(max < nums[i] + i){
                max = nums[i] + i;
                if(max >= l) return true;
            }
            if(max == i && nums[i] == 0)
                return false;
        }
        return true;
    }

    public boolean canJump4(int[] nums){
        int max = 0;
        for(int i = 0; i <= max; i++) {
            max = Math.max(max, i + nums[i]);
            if(max >= nums.length - 1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] t = {2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6};
        //int[] t = {2, 3, 1, 1, 4};
        No55JumpGame test = new No55JumpGame();
        System.out.println(test.canJump4(t));
    }
}
