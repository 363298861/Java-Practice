package Leetcode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class No46Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permute(nums, list, new ArrayList<Integer>());
        return list;
    }

    public void permute(int[] nums, List<List<Integer>> list, List<Integer> l){
        if(l.size() == nums.length) {
            list.add(l);
            return;
        }
        for(int i : nums){
            if(!l.contains(i)){
                List<Integer> newList = new ArrayList<>(l);
                newList.add(i);
                permute(nums, list, newList);
            }
        }
    }

    public static void main(String[] args) {
        No46Permutations n46 = new No46Permutations();
        int[] t = {1, 2, 3};
        System.out.println(n46.permute(t));
    }
}
