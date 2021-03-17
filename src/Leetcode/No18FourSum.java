package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No18FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int l = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        if(l == 0) return list;
        Arrays.sort(nums);
        for(int i = 0; i < l; i++){
            if(i > 0 && nums[i - 1] == nums[i]){   //avoid duplicated
                continue;
            }
            for(int j = i + 1; j < l; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){   //avoid duplicated
                    continue;
                }
                int lo = j + 1, hi = l - 1;
                while(lo < hi){
                    if(nums[i] + nums[j] + nums[lo] + nums[hi] == target){
                        list.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        while(lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while(lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++; hi--;
                    }else if(nums[i] + nums[j] + nums[lo] + nums[hi] < target){
                        lo++;
                    }else
                        hi--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] test = {-2, -1, -1, 1, 1, 2, 2};
        No18FourSum n = new No18FourSum();
        System.out.println(n.fourSum(test, 0));
    }
}
