package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No448DisappearedInts {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
                if(tmp != nums[i]) i--;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1)
                list.add(i + 1);
        }
        return list;
    }
}
