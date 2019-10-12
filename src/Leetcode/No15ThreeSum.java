package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No15ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List list = new ArrayList<List<Integer>>();
        List duplicates = new ArrayList<HashSet<Integer>>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triple = new ArrayList<>();
                        triple.add(nums[i]);
                        triple.add(nums[j]);
                        triple.add(nums[k]);
                        Set set = new HashSet();
                        set.add(nums[i]);
                        set.add(nums[j]);
                        set.add(nums[k]);
                        if(!duplicates.contains(set)){
                            list.add(triple);
                            duplicates.add(set);
                        }
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        No15ThreeSum n = new No15ThreeSum();
        int[] l = {-1, 0, 1, 2, -1, -4};
        System.out.println(n.threeSum(l));
    }
}
