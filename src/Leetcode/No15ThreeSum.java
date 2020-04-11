package Leetcode;

import java.util.*;

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
    public List<List<Integer>> threeSum2(int[] nums) {
        int l = nums.length;
        List list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < l - 2; i++){
            if(i == 0 || nums[i] != nums[i - 1]){
                int lo = i + 1, hi = l - 1, sum = -nums[i];
                while(lo < hi){
                    if(nums[lo] + nums[hi] == sum){
                        list.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while(lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while(lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;hi--;
                    }else if(nums[lo] + nums[hi] < sum){
                        lo++;
                    }else{
                        hi--;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        No15ThreeSum n = new No15ThreeSum();
        int[] l = {-1, 0, 1, 2, -1, -4};
        System.out.println(n.threeSum2(l));
    }
}
