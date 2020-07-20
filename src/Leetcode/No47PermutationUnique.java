package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No47PermutationUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permuteUnique(nums, list, new ArrayList<>(), new boolean[nums.length]);
        return list;
    }

    public void permuteUnique(int[] nums, List<List<Integer>> list, List<Integer> l, boolean[] used){
        if(l.size() == nums.length){
            if(!list.contains(l)) list.add(new ArrayList<>(l));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            l.add(nums[i]);
            used[i] = true;
            permuteUnique(nums, list, l, used);
            l.remove(l.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        No47PermutationUnique n47 = new No47PermutationUnique();
        int[] t = {1, 1, 2};
        System.out.println(n47.permuteUnique(t));
    }
}
