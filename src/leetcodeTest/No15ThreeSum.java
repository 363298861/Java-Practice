package leetcodeTest;

import java.util.*;

public class No15ThreeSum {
    // This uses hashmap, time complexity is o(n^2) and couldn't deal with duplicates
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        int l = nums.length;
        if(l == 0) return list;
        for(int i = 0; i < l; i++){
            Map<Integer, Integer> map = new HashMap<>();
            Map<Integer, Integer> map1 = new HashMap<>();
            for(int j = i + 1; j < l; j++){
                if(map.containsKey(-nums[j])){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[j]);
                    tmp.add(nums[map.get(-nums[j])]);
                    tmp.add(nums[map1.get(-nums[j])]);
                    list.add(tmp);
                }else {
                    map.put(nums[i] + nums[j], i);
                    System.out.println("i is: " + i + " and j is: " + j );
                    map1.put(nums[j] + nums[i], j);
                }
            }
        }
        return list;
    }

    public List<List<Integer>> threeSumBinarySearch(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        int l = nums.length;
        if(l == 0) return list;
        Arrays.sort(nums);
        for(int i = 0; i < l; i++){
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            int lo = i + 1, hi = l - 1;
            while(lo < hi) {
                if (nums[lo] + nums[hi] == -nums[i]) {
                    list.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while(lo < hi && nums[lo] == nums[lo + 1]) lo++;
                    while(lo < hi && nums[hi] == nums[hi - 1]) hi--;
                    lo++; hi--;
                } else if (nums[lo] + nums[hi] < -nums[i]) {
                    lo++;
                }else{
                    hi--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] test = {-1,0,1,2,-1,-4};
        No15ThreeSum n = new No15ThreeSum();
        System.out.println(n.threeSumBinarySearch(test));
    }
}
