package leetcodeTest;


import java.util.Arrays;

public class No16ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length; i++){
            int lo = i + 1, hi = nums.length - 1;
            while(lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                if(sum == target){
                    return sum;
                }else if(sum < target){
                    lo++;
                }else{
                    hi--;
                }
                if(Math.abs(target - res) > Math.abs(target - sum)){
                    res = sum;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {-1,2,1,-4};
        No16ThreeSumClosest n = new No16ThreeSumClosest();
        System.out.println(n.threeSumClosest(test, 1));
    }
}
