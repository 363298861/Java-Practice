package Leetcode;


import java.util.HashMap;
import java.util.Map;

public class No1TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] a = {0, 0};
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    a[0] = i;
                    a[1] = j;
                    return a;
                }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement))
                return new int[] {i, map.get(complement)};
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }



    public static void main(String[] args) {
        int[] c = {2, 7, 11, 15};
        int[] b = twoSum2(c, 18);
        System.out.println(b[0] + " " + b[1]);
    }
}
