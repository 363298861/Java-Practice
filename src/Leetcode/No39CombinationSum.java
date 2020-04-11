package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tmplist, int[] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tmplist));
        else{
            for(int i = start; i < nums.length; i++){
                tmplist.add(nums[i]);
                backtrack(list, tmplist, nums, remain - nums[i], i);
                tmplist.remove(tmplist.size() - 1);
            }
        }
    }
}
