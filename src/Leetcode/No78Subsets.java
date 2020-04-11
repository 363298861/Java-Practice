package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No78Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> tmplist, int[] nums, int start){
        if(!tmplist.isEmpty())
            list.add(new ArrayList<>(tmplist));
        for(int i = start; i < nums.length; i++){
            tmplist.add(nums[i]);
            backtrack(list, tmplist, nums, i + 1);
            tmplist.remove(tmplist.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        No78Subsets s = new No78Subsets();
        System.out.println(s.subsets(nums));
    }
}
