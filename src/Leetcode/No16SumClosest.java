package Leetcode;

import java.util.Arrays;

public class No16SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int gap = (int) Double.POSITIVE_INFINITY;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(gap > Math.abs(nums[i] + nums[j] + nums[k] - target)) {
                        gap = Math.abs(nums[i] + nums[j] + nums[k] - target);
                        res = nums[i] + nums[j] + nums[k];
                    }
                    if(res == target)
                        return target;
                }
            }
        }
        return res;
    }

    public int threeSumClosest2(int[] nums, int target){
        Arrays.sort(nums);
        int l = nums.length;
        int res = nums[0] + nums[1] + nums[l - 1];

        for(int i = 0; i < l - 2; i++){
            int lo = i + 1, hi = l - 1;
            while(lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                if(sum > target)
                    hi--;
                else
                    lo++;
                System.out.println(Math.abs(res -target));

                if( Math.abs(res -target) > Math.abs(sum - target))
                    res = sum;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        No16SumClosest t = new No16SumClosest();
        int[] nums = {1, 1, -1, -1, 3};
        System.out.println(t.threeSumClosest2(nums, -1));
    }
}
