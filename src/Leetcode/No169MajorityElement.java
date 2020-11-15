package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class No169MajorityElement {
    public int majorityElement(int[] nums) {
        int l = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < l; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
                if(l < 3) return nums[i];
            }else{
                map.put(nums[i], map.get(nums[i]) + 1);
                if(map.get(nums[i]) > l / 2) return nums[i];
            }
        }
        return -1;
    }
}
