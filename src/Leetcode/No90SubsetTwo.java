package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No90SubsetTwo {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> tmplist, int[] nums, int start){
        if(!list.contains(tmplist))
            list.add(new ArrayList<>(tmplist));
        for(int i = start; i < nums.length; i++){
            tmplist.add(nums[i]);
            backtrack(list, tmplist, nums, i + 1);
            tmplist.remove(tmplist.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] nums = {4, 4, 4, 1, 4};
        No90SubsetTwo s = new No90SubsetTwo();
        System.out.println(s.subsetsWithDup(nums));
    }
}
