package Leetcode;

public class No16SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int gap = (int) Double.POSITIVE_INFINITY;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(gap > Math.abs(nums[i] + nums[j] + nums[k] - target)) {
                        gap = Math.abs(nums[i] + nums[j] + nums[k] - target);
                        res = nums[i] + nums[j] + nums[k];
                    }
                    if(res == target)
                        return target;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        No16SumClosest t = new No16SumClosest();
        int[] nums = {-1, 2, 1, -4};
        System.out.println(t.threeSumClosest(nums, 1));
    }
}
