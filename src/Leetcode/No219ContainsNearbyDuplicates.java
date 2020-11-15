package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class No219ContainsNearbyDuplicates {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length && j <= i + k; j++){
                if(nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k){
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!set.add(nums[i]))
                return true;
            if(set.size() > k)
                set.remove(nums[i - k]);
        }
        return false;
    }
}
